package com.github.nikita_volkov.java.djdbc_java8.decoders;

import djdbc.Decoder;

import java.sql.*;
import java.util.Optional;

public final class OptionalDecoder<row> extends Decoder.Rows<Optional<row>> {
  private final Rows<row> subdecoder;

  public OptionalDecoder(Rows<row> subdecoder) {
    this.subdecoder = subdecoder;
  }

  @Override
  public Optional<row> run(ResultSet resultSet) throws SQLException {
    if (resultSet.next()) {
      return Optional.of(subdecoder.run(resultSet));
    }
    return Optional.empty();
  }

}
