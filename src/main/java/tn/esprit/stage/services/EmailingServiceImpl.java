package tn.esprit.stage.services;

import tn.esprit.stage.entities.Candidature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.Student;
import tn.esprit.stage.repositories.CandidatureRep;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmailingServiceImpl implements IEmailingServiceImpl {

    @Value("${spring.mail.username}")
    private String serverMail;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    CandidatureRep crep;
    static String TMP_UPLOAD_FOLDER ="E:\\Esprit DSI\\MobilityPlatform-Backend-\\tmp\\";

    //static String TMP_UPLOAD_FOLDER ="/dsi-esprit-reclamationservice/tmp/reclamation/";

    public void PreselectionMail(Candidature c) throws Exception {
        Student student = crep.findById(c.getId()).get().getStudent();
        // Mail Reclamation
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        MimeMessage mm = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm, true); // true = multipart
        String Template = "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <!--[if mso]>\n" +
                "  <noscript>\n" +
                "    <xml>\n" +
                "      <o:OfficeDocumentSettings>\n" +
                "        <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "      </o:OfficeDocumentSettings>\n" +
                "    </xml>\n" +
                "  </noscript>\n" +
                "  <![endif]-->\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:40px 0 30px 0;background:#4c72ee;\">\n" +
                "              <img src='cid:esprit' alt=\"\" width=\"300\" style=\"height:auto;display:block;\" />\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 42px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0 0 36px 0;color:#153643;\">\n" +
                "                    <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">"+student.getFirstName()+"</h1>\n" +
                "                    <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">"+
                "Hello <b>" + student.getFirstName() + " " + student.getLastName() + "," + "\n \n"
                + "Your enrollment for <b>"+c.getReceivinginstitution().getOrganisationLegalName()+"</b> of the following specialty, <b style=\"color:red;\">"+c.getSpecialty()
                +"<br>"
                +"<h3> You have been pre-selected and now you have pass the confirmation quiz.</h3></b>"
                +"<br>You can access your quiz by link below."
                + "<br> Quiz Link: "
                + "<br> Thank you and best of luck.\n\n"
                + "<br> Best regards," + "ESPRIT Mobility Team"+
                "                    <p style=\"margin:0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">"
                +"<a href=\"localhost:4000/showconfpres/detailsenroll/"+c.getId()+"/quiz/pass/"+c.getQuiz().getQuizId()+"\" style=\"color:#ee4c50;text-decoration:underline;\">Quiz link.</a>"
                +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#ee4c50;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0;width:50%;\" align=\"left\">\n" +
                "                    <p style=\"margin:0;font-size:14px;line-height:16px;font-family:Arial,sans-serif;color:#ffffff;\">\n" +
                "                      &reg; Someone, Somewhere 2024<br/><a href=\"http://www.example.com\" style=\"color:#ffffff;text-decoration:underline;\">Unsubscribe</a>\n" +
                "                    </p>\n" +
                "                  </td>\n" +
                "                  <td style=\"padding:0;width:50%;\" align=\"right\">\n" +
                "                    <table role=\"presentation\" style=\"border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                      <tr>\n" +
                "                        <td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "                          <a href=\"http://www.twitter.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/tw_1.png\" alt=\"Twitter\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n" +
                "                        </td>\n" +
                "                        <td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "                          <a href=\"http://www.facebook.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/fb_1.png\" alt=\"Facebook\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </table>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>";


        helper.setFrom(serverMail);
        helper.setTo(student.getEmail());
        helper.setText(Template,true);
        helper.setSubject("Confirmation "+student.getFirstName());

        FileSystemResource res = new FileSystemResource(new File(TMP_UPLOAD_FOLDER+"esprit.jpg"));
        helper.addInline("esprit", res);

        emailSender.send(mm);

    }

    public void ConfirmationMail(Candidature c) throws Exception {
        Student student = crep.findById(c.getId()).get().getStudent();
        // Mail Reclamation
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        MimeMessage mm = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm, true); // true = multipart
        String Template = "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <!--[if mso]>\n" +
                "  <noscript>\n" +
                "    <xml>\n" +
                "      <o:OfficeDocumentSettings>\n" +
                "        <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "      </o:OfficeDocumentSettings>\n" +
                "    </xml>\n" +
                "  </noscript>\n" +
                "  <![endif]-->\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:40px 0 30px 0;background:#4c72ee;\">\n" +
                "              <img src='cid:esprit' alt=\"\" width=\"300\" style=\"height:auto;display:block;\" />\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 42px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0 0 36px 0;color:#153643;\">\n" +
                "                    <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">"+student.getFirstName()+"</h1>\n" +
                "                    <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">"+
                                        "Hello <b>" + student.getFirstName() + " " + student.getLastName() + "," + "\n \n"
                                        +"<h3> you have successfully passed the confirmation quiz.</h3></b>"
                                        + "Your enrollment for <b>"+c.getReceivinginstitution().getOrganisationLegalName()+"</b> of the following specialty, <b style=\"color:red;\">"+c.getSpecialty()
                                        +"</b> has been confirmed on:"+dateFormat.format(c.getConfirmationD())
                                        +"<br>"
                                        +"<br>Enrollment details: "
                                        + "<br>Receiving institution's contact person:<br>\n"
                                        +"Name:"+c.getReceivinginstitution().getContactperson().getName()
                                        +"Email:"+c.getReceivinginstitution().getContactperson().getCpemail()
                                        + "<br>Your current institution's contact person:<br>\n"
                                        +"Name:"+c.getSendinginstitution().getContactperson().getName()
                                        +"Email:"+c.getSendinginstitution().getContactperson().getCpemail()
                                        + "<br>Congratulations. We look forward to hearing from you again Regards,"
                                        + "ESPRIT Mobility Team"
                                        + "<br> Enrollment Link: "
                                        +
                "                    <p style=\"margin:0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">" +
                "                      <a href=\"localhost:4000/showconfpres/detailsenroll/"+c.getId()+"\" style=\"color:#ee4c50;text-decoration:underline;\">Enrollment."+"</a></p>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#ee4c50;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0;width:50%;\" align=\"left\">\n" +
                "                    <p style=\"margin:0;font-size:14px;line-height:16px;font-family:Arial,sans-serif;color:#ffffff;\">\n" +
                "                      &reg; Someone, Somewhere 2024<br/><a href=\"http://www.example.com\" style=\"color:#ffffff;text-decoration:underline;\">Unsubscribe</a>\n" +
                "                    </p>\n" +
                "                  </td>\n" +
                "                  <td style=\"padding:0;width:50%;\" align=\"right\">\n" +
                "                    <table role=\"presentation\" style=\"border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                      <tr>\n" +
                "                        <td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "                          <a href=\"http://www.twitter.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/tw_1.png\" alt=\"Twitter\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n" +
                "                        </td>\n" +
                "                        <td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "                          <a href=\"http://www.facebook.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/fb_1.png\" alt=\"Facebook\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </table>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>";


        helper.setFrom(serverMail);
        helper.setTo(student.getEmail());
        helper.setText(Template,true);
        helper.setSubject("Confirmation "+student.getFirstName());

        FileSystemResource res = new FileSystemResource(new File(TMP_UPLOAD_FOLDER+"esprit.jpg"));
        helper.addInline("esprit", res);

        emailSender.send(mm);

    }


}
