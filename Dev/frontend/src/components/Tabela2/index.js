import React from "react";

import {
  StyledTableCell,
  StyledTableRow,
  useStyles,
  Titulo,
  Texto,
} from "./styles";

import Acoes from "./Acoes";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableBody from "@material-ui/core/TableBody";
import Table from "@material-ui/core/Table";
import Paper from "@material-ui/core/Paper";

export default function Tabela2({
  dados,
  tipo,
  temAcoes = true,
  detalhes,
  editarFuncao,
  soDetalhes,
}) {
  const classes = useStyles();
  const cabecalho = [];
  const colunas = [];

  if (dados.length) {
    for (const [key /* , value */] of Object.entries(dados[0])) {
      cabecalho.push(key);
      let coluna = key.replace(/_/g, " ");
      colunas.push(coluna);
    }
  }

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simples table">
        <TableHead>
          <StyledTableRow>
            {colunas.map((coluna) => (
              <StyledTableCell key={coluna}>
                <Titulo>{coluna}</Titulo>
              </StyledTableCell>
            ))}
            {temAcoes && (
              <StyledTableCell>
                <Titulo>Ações</Titulo>
              </StyledTableCell>
            )}
          </StyledTableRow>
        </TableHead>
        <TableBody>
          {dados.map((linha) => (
            <StyledTableRow key={linha.id}>
              {cabecalho.map((coluna, index) => (
                <StyledTableCell align="left" key={`${linha[coluna]}${index}`}>
                  <Texto>{linha[coluna]}</Texto>
                </StyledTableCell>
              ))}
              {temAcoes && (
                <Acoes
                  id={linha.id}
                  tipo={tipo}
                  detalhes={detalhes}
                  editarFuncao={editarFuncao}
                  soDetalhes={soDetalhes}
                />
              )}
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
