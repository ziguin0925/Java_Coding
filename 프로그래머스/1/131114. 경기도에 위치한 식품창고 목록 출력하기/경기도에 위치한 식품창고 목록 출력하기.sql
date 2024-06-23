-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') 'FREEZER_YN'
    FROM food_warehouse
    WHERE warehouse_name LIKE '%경기%'
    ORDER BY WAREHOUSE_ID;