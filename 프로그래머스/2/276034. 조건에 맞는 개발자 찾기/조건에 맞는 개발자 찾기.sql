-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE DEVELOPERS.SKILL_CODE &
(SELECT CODE
 FROM SKILLCODES
 WHERE NAME = 'C#'
) OR
DEVELOPERS.SKILL_CODE &
(SELECT CODE
 FROM SKILLCODES
 WHERE NAME = 'PYTHON'
)
ORDER BY ID;