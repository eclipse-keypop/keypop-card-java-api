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
package org.eclipse.keypop.card.spi;

import org.eclipse.keypop.card.CardSelectionResponseApi;
import org.eclipse.keypop.card.ParseException;

/**
 * Extension of the card selection for a specific card extension.
 *
 * <p>Provides the {@link CardSelectionRequestSpi} and interprets the result to provide a {@link
 * SmartCardSpi}.
 *
 * <p>Backside of the <b>org.eclipse.keypop.reader.selection.spi.CardSelectionExtension</b>
 * interface present in the <b>Keypop Reader API</b>.
 *
 * <p>An adapter of this interface must also implement <b>CardSelectionExtension</b>.
 *
 * @since 2.0.0
 */
public interface CardSelectionExtensionSpi {

  /**
   * Gets the card selection request containing the selection data prepared for this selection.
   *
   * @return A non-null reference.
   * @since 1.0.0
   */
  CardSelectionRequestSpi getCardSelectionRequest();

  /**
   * Analyzes the response received from the card during the selection process and creates a {@link
   * SmartCardSpi}.
   *
   * @param cardSelectionResponseApi The card selection response.
   * @return A non-null reference.
   * @throws ParseException If the card selection response parsing failed.
   * @since 1.0.0
   */
  SmartCardSpi parse(CardSelectionResponseApi cardSelectionResponseApi) throws ParseException;
}
