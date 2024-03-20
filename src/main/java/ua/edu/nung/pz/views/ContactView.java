package ua.edu.nung.pz.views;

public class ContactView {

    public static String getContactForm() {
        return "<div class=\"container-fluid px-5 my-5\">\n" +
                "  <div class=\"row justify-content-center\">\n" +
                "    <div class=\"col-xl-10\">\n" +
                "      <div class=\"card border-0 rounded-3 shadow-lg overflow-hidden\">\n" +
                "        <div class=\"card-body p-0\">\n" +
                "          <div class=\"row g-0\">\n" +
                "            <div class=\"col-sm-6 d-none d-sm-block bg-image\"></div>\n" +
                "            <div class=\"col-sm-6 p-4\">\n" +
                "              <div class=\"text-center\">\n" +
                "                <div class=\"h3 fw-light\">Contact Form</div>\n" +
                "                <p class=\"mb-4 text-muted\">Split layout contact form</p>\n" +
                "              </div>\n" +
                "\n" +
                "              <!-- * * * * * * * * * * * * * *\n" +
                "          // * * SB Forms Contact Form * *\n" +
                "          // * * * * * * * * * * * * * * *\n" +
                "\n" +
                "          // This form is pre-integrated with SB Forms.\n" +
                "          // To make this form functional, sign up at\n" +
                "          // https://startbootstrap.com/solution/contact-forms\n" +
                "          // to get an API token!\n" +
                "          -->\n" +
                "\n" +
                "              <form id=\"contactForm\" data-sb-form-api-token=\"API_TOKEN\">\n" +
                "\n" +
                "                <!-- Name Input -->\n" +
                "                <div class=\"form-floating mb-3\">\n" +
                "                  <input class=\"form-control\" id=\"name\" type=\"text\" placeholder=\"Name\" data-sb-validations=\"required\" />\n" +
                "                  <label for=\"name\">Name</label>\n" +
                "                  <div class=\"invalid-feedback\" data-sb-feedback=\"name:required\">Name is required.</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <!-- Email Input -->\n" +
                "                <div class=\"form-floating mb-3\">\n" +
                "                  <input class=\"form-control\" id=\"emailAddress\" type=\"email\" placeholder=\"Email Address\" data-sb-validations=\"required,email\" />\n" +
                "                  <label for=\"emailAddress\">Email Address</label>\n" +
                "                  <div class=\"invalid-feedback\" data-sb-feedback=\"emailAddress:required\">Email Address is required.</div>\n" +
                "                  <div class=\"invalid-feedback\" data-sb-feedback=\"emailAddress:email\">Email Address Email is not valid.</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <!-- Message Input -->\n" +
                "                <div class=\"form-floating mb-3\">\n" +
                "                  <textarea class=\"form-control\" id=\"message\" type=\"text\" placeholder=\"Message\" style=\"height: 10rem;\" data-sb-validations=\"required\"></textarea>\n" +
                "                  <label for=\"message\">Message</label>\n" +
                "                  <div class=\"invalid-feedback\" data-sb-feedback=\"message:required\">Message is required.</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <!-- Submit success message -->\n" +
                "                <div class=\"d-none\" id=\"submitSuccessMessage\">\n" +
                "                  <div class=\"text-center mb-3\">\n" +
                "                    <div class=\"fw-bolder\">Form submission successful!</div>\n" +
                "                    <p>To activate this form, sign up at</p>\n" +
                "                    <a href=\"https://startbootstrap.com/solution/contact-forms\">https://startbootstrap.com/solution/contact-forms</a>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <!-- Submit error message -->\n" +
                "                <div class=\"d-none\" id=\"submitErrorMessage\">\n" +
                "                  <div class=\"text-center text-danger mb-3\">Error sending message!</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <!-- Submit button -->\n" +
                "                <div class=\"d-grid\">\n" +
                "                  <button class=\"btn btn-primary btn-lg disabled\" id=\"submitButton\" type=\"submit\">Submit</button>\n" +
                "                </div>\n" +
                "              </form>\n" +
                "              <!-- End of contact form -->\n" +
                "\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "<!-- CDN Link to SB Forms Scripts -->\n" +
                "<script src=\"https://cdn.startbootstrap.com/sb-forms-latest.js\"></script>";
    }
}
