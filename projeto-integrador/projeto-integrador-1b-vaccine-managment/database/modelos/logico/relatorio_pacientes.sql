SELECT
    p.ID_Paciente,
    p.Nome,
    p.Data_Nascimento,
    p.Endereco,
    r.Nome_Regiao AS 'Região',
    e.Nivel AS 'Escolaridade'
FROM
    Paciente AS p
JOIN
    Regiao AS r ON p.ID_Regiao = r.ID_Regiao
JOIN
    Escolaridade AS e ON p.ID_Escolaridade = e.ID_Escolaridade;