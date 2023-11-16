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
import org.eclipse.keypop.card.CardSelectionResponseApi;

/**
 * Data provided as input to the selection process.
 *
 * <p>Embeds a card selector defining the target card profile and an optional card request to be
 * executed after the card selection when successful.
 *
 * @see CardSelectionResponseApi
 * @since 1.0.0
 */
public interface CardSelectionRequestSpi {

  /**
   * Gets the list of successful selection status words.
   *
   * @return A set of integer values containing at least 9000h.
   * @since 2.0.0
   */
  Set<Integer> getSuccessfulSelectionStatusWords();

  /**
   * Gets the card request.
   *
   * @return Null if no card request has been defined.
   * @since 1.0.0
   */
  CardRequestSpi getCardRequest();
}
