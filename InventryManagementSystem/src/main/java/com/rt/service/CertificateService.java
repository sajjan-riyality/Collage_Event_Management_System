package com.rt.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.rt.entity.EventRegistration;
import com.rt.repository.EventRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    public ByteArrayInputStream generateCertificate(Long registrationId) {
        Optional<EventRegistration> registrationOpt = eventRegistrationRepository.findById(registrationId);

        if (!registrationOpt.isPresent()) {
            throw new RuntimeException("Registration not found for ID: " + registrationId);
        }

        EventRegistration registration = registrationOpt.get();

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.BLACK);
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.DARK_GRAY);

            Paragraph title = new Paragraph("Certificate of Participation", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(30);
            document.add(title);

            Paragraph content = new Paragraph(
                    "This is to certify that " + registration.getUser().getUsername() +
                            " has successfully participated in the event \"" +
                            registration.getEvent().getTitle() + "\".", contentFont);
            content.setAlignment(Element.ALIGN_CENTER);
            content.setSpacingAfter(20);
            document.add(content);

            Paragraph date = new Paragraph("Date: " + registration.getRegistrationTime().toLocalDate(), contentFont);
            date.setAlignment(Element.ALIGN_CENTER);
            document.add(date);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
