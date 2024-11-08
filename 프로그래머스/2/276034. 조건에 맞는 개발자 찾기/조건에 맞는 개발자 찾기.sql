/*
SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
    FROM DEVELOPERS as D
    WHERE D.SKILL_CODE & 256
    or D.SKILL_CODE & 1024
    ORDER BY D.ID;
*/

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
    FROM developers
    WHERE SKILL_CODE &(SELECT CODE FROM SKILLCODES WHERE NAME LIKE 'Python')
    OR SKILL_CODE&(SELECT CODE FROM SKILLCODES WHERE NAME LIKE 'C#')
    ORDER BY ID;
