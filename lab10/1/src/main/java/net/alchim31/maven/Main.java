package net.alchim31.maven;

import org.apache.spark.sql.*;

// https://www.kaggle.com/datasets/rahulvyasm/netflix-movies-and-tv-shows?resource=download
// Датасет Netflix Movies and TV Shows - все фильмы и шоу нетфликса

public class Main {
    public static void main(String[] args) {
        System.out.println("Инициализация spark");

        SparkSession sparkSession = SparkSession.builder().appName("spark_test.com").master("local[*]").getOrCreate();
        sparkSession.sparkContext().setLogLevel("ERROR");

        String path = System.getProperty("user.dir") + "/netflix_titles.csv";
        Dataset<Row> dataset = sparkSession.read().format("csv").option("header", "true").load(path);
        dataset.createOrReplaceTempView("netflix");

        System.out.println("\n\nРезультаты запросов:");

        System.out.println("\n1. Пример записей");
        sparkSession.sql("select * from netflix limit 10").show();

        System.out.println("\n2. Пропорция фильмов и передач");
        sparkSession.sql("select sum(case when type = 'Movie' then 1 end) / count(*) * 100 as `Процент фильмов`, sum(case when type = 'TV Show' then 1 end) / count(*) * 100 as `Процент передач` from netflix").show();

        System.out.println("\n3. Самые популярные режиссеры");
        sparkSession.sql("select explode(SPLIT(director, ', ')) as director, count(*) as `Количество работ` from netflix where director is not null group by director order by 2 desc limit 10").show();

        System.out.println("\n4. Страны, выпускавшие фильмы в разные годы");
        sparkSession.sql("select release_year, explode(SPLIT(country, ', ')) as country, count(*) from netflix where release_year > 1980 group by 1, 2 order by 1, 3 desc limit 10").show();

        System.out.println("\n5. Средняя продолжительность фильмов");
        sparkSession.sql("select AVG(TRIM(SUBSTRING(duration, 1, 3))) as `Средня продолжительность` from netflix where type='Movie'").show();

        System.out.println("\n6. Самые часто снимающиеся актеры");
        sparkSession.sql("select explode(SPLIT(cast, ', ')) as `Актер`, count(*) as `Количество` from netflix group by 1 order by 2 desc").show();

        System.out.println("\n7. Фильмы, содержащие в описаниии journey");
        sparkSession.sql("select title from netflix where description LIKE '%journey%'").show();

        System.out.println("\n8. Возрастное деление");
        sparkSession.sql("select rating, count(*) from netflix group by rating order by 2 desc limit 10").show();

        System.out.println("\n9. Самые частые жанры");
        sparkSession.sql("select explode(SPLIT(listed_in, ', ')) as `Жанр`, count(*) as `Количество` from netflix group by 1 order by 2 desc").show();

        System.out.println("\n10. Жанры, которые снимают режиссеры");
        sparkSession.sql("select director as `Режиссер`, concat_ws(', ', collect_set(listed_in)) as `Жанры` from netflix group by 1").show();

        sparkSession.stop();
    }
}