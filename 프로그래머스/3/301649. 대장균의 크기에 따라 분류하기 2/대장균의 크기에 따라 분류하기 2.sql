
SELECT A.ID, 
CASE WHEN A.PERCENT <= 0.25 THEN 'CRITICAL'
    WHEN A.PERCENT <= 0.5 THEN 'HIGH'
    WHEN A.PERCENT <= 0.75 THEN 'MEDIUM'
    ELSE 'LOW'
    END COLONY_NAME
FROM (SELECT ID, PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS PERCENT
        FROM ECOLI_DATA
        ORDER BY SIZE_OF_COLONY DESC) A
ORDER BY ID;