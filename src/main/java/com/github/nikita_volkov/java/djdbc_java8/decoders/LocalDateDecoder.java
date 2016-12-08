package com.github.nikita_volkov.java.djdbc_java8.decoders;

import djdbc.Decoder;

import java.sql.*;
import java.time.LocalDate;

public final class LocalDateDecoder extends Decoder.Rows<LocalDate> {

  private final int index;

  public LocalDateDecoder(int index) {
    this.index = index;
  }

  @Override
  public LocalDate run(ResultSet resultSet) throws SQLException {
    return resultSet.getDate(index).toLocalDate();
  }

}
