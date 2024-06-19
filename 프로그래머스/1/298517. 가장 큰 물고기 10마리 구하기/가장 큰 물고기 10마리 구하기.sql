-- 코드를 작성해주세요

Select ID,LENGTH
    FROM FISH_INFO
    where LENGTH is not null
    ORDER BY LENGTH desc, ID
    LIMIT 10;