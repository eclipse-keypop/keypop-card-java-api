/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.card.spi;

import java.util.Set;
import org.eclipse.keypop.card.ApduResponseApi;

/**
 * Data to build a single APDU command to be sent to a card.
 *
 * @see ApduResponseApi
 * @since 1.0.0
 */
public interface ApduRequestSpi {

  /**
   * Gets the APDU bytes to be sent to the card.
   *
   * @return An array of at least 4 bytes.
   * @since 1.0.0
   */
  byte[] getApdu();

  /**
   * Gets the list of status words that must be considered successful for the APDU.
   *
   * @return A set of integer values containing at least 9000h.
   * @since 1.0.0
   */
  Set<Integer> getSuccessfulStatusWords();

  /**
   * Gets the information about this APDU request (e.g. command name).
   *
   * <p>These information are intended to improve the logging.
   *
   * @return Null if no information has been defined.
   * @since 1.0.0
   */
  String getInfo();
}
