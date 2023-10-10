package services;

import models.Receipt;

public interface ReceiptService {
    Receipt save(Receipt receipt);
    Receipt findById(Long id);
    Receipt findLast();
}
