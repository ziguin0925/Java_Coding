-- 코드를 입력하세요 
SELECT TO_NUMBER(SUBSTR(t2.SALES_DATE,0,4)) YEAR, TO_NUMBER(SUBSTR(t2.SALES_DATE,5,6)) MONTH, t1.GENDER, COUNT(DISTINCT t1.USER_ID) USERS
    FROM 
    (SELECT *
        FROM USER_INFO
        WHERE GENDER is not NULL) t1 ,
    (SELECT ONLINE_SALE_ID,
     USER_ID,
     PRODUCT_ID,
     SALES_AMOUNT,
     TO_CHAR(SALES_DATE,'yyyymm') SALES_DATE
        FROM ONLINE_SALE) t2
    WHERE t1.USER_ID = t2.USER_ID
    GROUP BY t2.SALES_DATE, t1.GENDER
    ORDER BY SALES_DATE, GENDER;
    

    