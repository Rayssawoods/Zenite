import React from "react";
import { useField } from "formik";
import { Container, Rotulo, Input, TextoAlerta, ErrorMessage } from "./styles";

export default function InputFormik(props) {
  const {
    texto,
    pequeno,
    tamanho,
    invalido,
    textoAlerta,
    required,
    mask,
  } = props;

  const [field, meta] = useField(props.name);
  const [didFocus, setDidFocus] = React.useState(false);

  const handleFocus = () => setDidFocus(true);

  const showFeedback = !!didFocus || !!meta.touched;

  return (
    <Container>
      {texto && (
        <Rotulo>
          {texto} {required && "*"}
        </Rotulo>
      )}
      {textoAlerta && <TextoAlerta>{textoAlerta}</TextoAlerta>}
      <Input
        {...props}
        {...field}
        mask={mask}
        onFocus={handleFocus}
        feedback={showFeedback ? (!!meta.error ? 1 : 0) : 0}
        pequeno={pequeno}
        tamanho={tamanho}
        invalido={invalido}
      />
      {showFeedback
        ? meta.error && <ErrorMessage>{meta.error}</ErrorMessage>
        : null}
    </Container>
  );
}
