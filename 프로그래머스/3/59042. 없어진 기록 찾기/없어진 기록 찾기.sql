-- 코드를 입력하세요
SELECT t1.animal_id, t1.name
    from animal_outs t1
    where not exists(select animal_id from animal_ins t2 where t1.animal_id=t2.animal_id)
    order by animal_id, name