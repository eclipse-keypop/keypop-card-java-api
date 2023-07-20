/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.card;

import java.io.Serializable;
import org.eclipse.keypop.card.spi.ApduRequestSpi;

/**
 * Data received in response to an APDU command.
 *
 * <p>Consists in a data part of variable length and a status word (SW1SW2).
 *
 * @see ApduRequestSpi
 * @since 1.0.0
 */
public interface ApduResponseApi extends Serializable {

  /**
   * Gets the raw data received from the card (including the status word).
   *
   * @return An array of at least 2 bytes.
   * @since 1.0.0
   */
  byte[] getApdu();

  /**
   * Gets the data part of the response received from the card (excluding the status word).
   *
   * @return A non-null byte array.
   * @since 1.0.0
   */
  byte[] getDataOut();

  /**
   * Gets the status word of the APDU as an int.
   *
   * @return An integer between 0000h and FFFFh.
   * @since 1.0.0
   */
  int getStatusWord();
}
