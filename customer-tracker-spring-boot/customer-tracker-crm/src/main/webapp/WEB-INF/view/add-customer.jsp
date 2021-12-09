<%@include file="header.jsp" %>
    <div class="container padding-top">
        <a href = "/customers-list" style="text-decoration: none">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M7.78 12.53a.75.75 0 01-1.06 0L2.47 8.28a.75.75 0 010-1.06l4.25-4.25a.75.75 0 011.06 1.06L4.81 7h7.44a.75.75 0 010 1.5H4.81l2.97 2.97a.75.75 0 010 1.06z"></path></svg> back to list
        </a>
        <div style="height : 25px"></div>
        <h4 class="mb-3">Save Customer</h4>
        <form class="needs-validation" novalidate="" action="/saveCustomerForm" method="POST">

          <div class="row g-3">
            <div class="col-sm-6">
              <label for="firstName" class="form-label">First name</label>
              <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required="true">
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
          </div>

          <div class="row g-3">
            <div class="col-sm-6">
              <label for="lastName" class="form-label">Last name</label>
              <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required="true">
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>
            </div>

            <div class="row g-3">
                <div class="col-sm-6">
                  <label for="email" class="form-label">Email</label>
                  <input type="text" class="form-control" id="email" name="email" placeholder="" value="" required="true">
                  <div class="invalid-feedback">
                    Valid email is required.
                  </div>
                </div>
             </div>
             <br>
          <button class="btn btn-style-color" type="submit">Add Customer</button>
        </form>


    </div>
<%@include file="footer.jsp" %>