/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CardApiPropertiesTest {

  private static String libVersion;

  @BeforeAll
  public static void beforeAll() throws Exception {
    InputStream inputStream = new FileInputStream("gradle.properties");
    try {
      Properties properties = new Properties();
      properties.load(inputStream);
      libVersion = properties.getProperty("version");
    } finally {
      inputStream.close();
    }
  }

  @Test
  public void versionIsCorrectlyWritten() {
    String apiVersion = CardApiProperties.VERSION;
    assertThat(apiVersion).matches("\\d+\\.\\d+");
    assertThat(libVersion).startsWith(apiVersion);
  }
}
