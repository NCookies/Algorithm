SELECT ANIMAL_ID, NAME, 
       IF(SUBSTR(SEX_UPON_INTAKE, 1, 6) = "Intact", "X", "O") AS "중성화"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID