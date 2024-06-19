-- 코드를 작성해주세요
SELECT COUNT(*) 'COUNT'
    FROM ECOLI_DATA
    WHERE BIN(GENOTYPE) & b'0111'= 5 
         or BIN(GENOTYPE) & b'0111'= 4
         or BIN(GENOTYPE) & b'0111'= 1; 