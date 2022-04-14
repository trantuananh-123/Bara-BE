package tran.tuananh.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tran.tuananh.model.Product;
import tran.tuananh.model.User;

@Service
public class MailServiceImp implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendEmail(User user) throws MailException {
		// TODO Auto-generated method stub
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("Bara shop message to you");
		mail.setText("Thank you for shopping!");

		javaMailSender.send(mail);
		return "Send successfully";
	}

	@Override
	public String sendEmailWithAttachment(User user) throws MailException, MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");

		String msg = "<h3>Testing mail service</h3>"
				+ "<img src='https://angular.io/assets/images/logos/angularjs/AngularJS-Shield.svg'>";

		StringBuilder contentMail = new StringBuilder();
		contentMail.append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\r\n"
				+ "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\r\n"
				+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n"
				+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\r\n"
				+ "\r\n"
				+ "    <style>\r\n"
				+ "        img {\r\n"
				+ "            max-width: 50%;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "        <h1 class=\"text-center\">Bara</h1>\r\n"
				+ "        <hr>\r\n"
				+ "        <h3>Chào Tuấn Anh</h3>\r\n"
				+ "        <p>Cảm ơn vì đã mua hàng</p>\r\n"
				+ "        <p>Mã đơn hàng: #1001698733</p>\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "            <div class=\"col-md-3\">\r\n"
				+ "                <p>Hình ảnh</p>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"col-md-3\">\r\n"
				+ "                <p>Tên sản phẩm</p>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"col-md-3\">\r\n"
				+ "                Số lượng\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"col-md-3\">\r\n"
				+ "                Giá\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n");
		List<Product> data = new ArrayList<Product>();
		for(Product pro: data) {
			contentMail.append("<div class=\"row\">\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                <p>Hình ảnh</p>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                <p>Tên sản phẩm</p>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                Số lượng\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                Giá\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"row\">\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                <img src=\"https://angular.io/assets/images/logos/angularjs/AngularJS-Shield.svg\" alt=\"\">\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                <p>"+pro.getProductName()+"\"</p>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                2\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-3\">\r\n"
					+ "                <p>"+pro.getProductPriceOut()+"\"</p>\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "        <hr>\r\n"
					+ "        <div class=\"row\">\r\n"
					+ "            <div class=\"col-md-6\">\r\n"
					+ "                <p>Tổng giá trị sản phẩm: </p>\r\n"
					+ "                <p>Khuyến mãi: </p>\r\n"
					+ "                <p>Địa chỉ: </p>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"col-md-6\">\r\n"
					+ "                <p>$120</p>\r\n"
					+ "                <p>$0</p>\r\n"
					+ "                <p>Nghĩa Tân, Cầu Giấy, Hà Nội</p>\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n" + "</html>");
		}
		mimeMessage.setContent(contentMail, "text/html;charset=utf-8");
		helper.setTo(user.getEmail());
		helper.setSubject("Bara shop message to you");
		javaMailSender.send(mimeMessage);
		return "Send successfully";
	}

}
