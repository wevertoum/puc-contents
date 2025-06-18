SELECT
    p.Nome AS 'Paciente',
    v.Nome_Vacina AS 'Vacina Aplicada',
    av.Data_Aplicacao AS 'Data da Aplicação',
    av.Numero_Dose AS 'Dose',
    (SELECT GROUP_CONCAT(d.Nome_Doenca SEPARATOR ', ')
     FROM Vacina_Previne_Doenca vpd
     JOIN Doenca d ON vpd.ID_Doenca = d.ID_Doenca
     WHERE vpd.ID_Vacina = av.ID_Vacina) AS 'Doenças que a Vacina Previne'
FROM
    Aplicacao_Vacina AS av
JOIN
    Paciente AS p ON av.ID_Paciente = p.ID_Paciente
JOIN
    Vacina AS v ON av.ID_Vacina = v.ID_Vacina
ORDER BY
    p.Nome, av.Data_Aplicacao;