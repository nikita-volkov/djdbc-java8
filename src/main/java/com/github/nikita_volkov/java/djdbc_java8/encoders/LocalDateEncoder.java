package com.github.nikita_volkov.java.djdbc_java8.encoders;

import djdbc.Encoder;

import java.sql.*;
import java.time.LocalDate;

public final class LocalDateEncoder implements Encoder<LocalDate> {

  private final int index;

  public LocalDateEncoder(int index) {
    this.index = index;
  }

  @Override
  public void encodeParams(PreparedStatement preparedStatement, LocalDate x) throws SQLException {
    preparedStatement.setDate(index, Date.valueOf(x));
  }

}
