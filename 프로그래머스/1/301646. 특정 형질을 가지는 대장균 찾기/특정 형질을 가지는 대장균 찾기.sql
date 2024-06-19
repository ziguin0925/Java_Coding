-- 코드를 작성해주세요
SELECT COUNT(*) 'COUNT'
    FROM ECOLI_DATA
    WHERE 
          BIN(GENOTYPE) & b'0110'= 4
         or BIN(GENOTYPE) & b'0011'= 1;