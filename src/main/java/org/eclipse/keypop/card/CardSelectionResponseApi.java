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

import org.eclipse.keypop.card.spi.CardRequestSpi;
import org.eclipse.keypop.card.spi.CardSelectionRequestSpi;

/**
 * Data from the start-up phase with the card: selection data and any additional responses.
 *
 * <p>Includes the status of the selection itself and the responses to any commands that may have
 * been executed afterward.
 *
 * @see CardSelectionRequestSpi
 * @since 1.0.0
 */
public interface CardSelectionResponseApi {

  /**
   * Gets the card's power-on data.
   *
   * <p>The power-on data is defined as the data retrieved by the reader when the card is inserted.
   *
   * <p>In the case of a contact reader, this is the Answer To Reset data (ATR) defined by ISO7816.
   *
   * <p>In the case of a contactless reader, the reader decides what this data is.<br>
   * Some contactless readers provide a virtual ATR (partially standardized by the PC/SC standard),
   * but other devices can have their own definition, including for example elements from the
   * anti-collision stage of the ISO14443 protocol (ATQA, ATQB, ATS, SAK, etc) or any proprietary
   * definitions.
   *
   * <p>These data being variable from one reader to another, they are defined here in string format
   * which can be either a hexadecimal string or any other relevant information.
   *
   * @return Null if no power-on data is available.
   * @since 1.0.0
   */
  String getPowerOnData();

  /**
   * Gets the {@link ApduResponseApi} received from the card in response to the <b>Select
   * Application</b> command.
   *
   * @return Null if no Select Application command was performed.
   * @since 1.0.0
   */
  ApduResponseApi getSelectApplicationResponse();

  /**
   * Gives the selection process status.
   *
   * @return True if the card inserted matches the selection filters.
   * @since 1.0.0
   */
  boolean hasMatched();

  /**
   * Gets the responses of the card to the requests present in the {@link CardRequestSpi} from the
   * {@link CardSelectionRequestSpi}.
   *
   * @return Null if no requests have been set.
   * @since 1.0.0
   */
  CardResponseApi getCardResponse();
}
