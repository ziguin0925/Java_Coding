-- 코드를 입력하세요
SELECT t1.book_id, t2.author_name, to_char(t1.published_date,'yyyy-mm-dd') PUBLISHED_DATE
    FROM BOOK t1, AUTHOR t2
    WHERE t1.AUTHOR_ID = t2.AUTHOR_ID AND t1.CATEGORY = '경제'
    ORDER BY published_date;