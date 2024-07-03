-- 코드를 입력하세요
SELECT t1.product_code , sum(SALES_AMOUNT*price) sales
    FROM PRODUCT t1, OFFLINE_SALE t2
    WHERE t1.product_id = t2.product_id     
    GROUP BY t1.product_code
    order by sales desc, product_code;