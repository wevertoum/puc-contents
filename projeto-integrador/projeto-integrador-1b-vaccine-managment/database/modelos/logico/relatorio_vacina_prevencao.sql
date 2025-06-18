SELECT
    v.Nome_Vacina AS 'Vacina',
    d.Nome_Doenca AS 'Doença Prevenida'
FROM
    Vacina_Previne_Doenca AS vpd
JOIN
    Vacina AS v ON vpd.ID_Vacina = v.ID_Vacina
JOIN
    Doenca AS d ON vpd.ID_Doenca = d.ID_Doenca
ORDER BY
    v.Nome_Vacina;