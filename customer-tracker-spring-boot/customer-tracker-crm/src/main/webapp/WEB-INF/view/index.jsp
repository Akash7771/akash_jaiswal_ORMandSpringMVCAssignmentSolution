<%@include file="header.jsp" %>
    <div class="container padding-top">
        <a href = "${pageContext.request.contextPath}/addCustomer">
            <button type="button" class="btn btn-style-color">Add Customer</button>
        </a>
        <div style="height : 25px"></div>

        <table class="table table-striped table-hover">
            <thead>
            	<tr>
	                <td># Customer Id</td>
	                <td>First Name</td>
	                <td>Last Name</td>
	                <td>Email</td>
	                <td>Action</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="theCustomer" items="${theCustomersList}">
                <tr>
                  <th scope="row"><c:out value="${theCustomer.customerId}"/></th>
                  <td><c:out value="${theCustomer.firstName}"/></td>
                  <td><c:out value="${theCustomer.lastName}"/></td>
                  <td><c:out value="${theCustomer.email}"/></td>
                  <td><a href='${pageContext.request.contextPath}/updateCustomer?customerId=${theCustomer.customerId}'><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"></path></svg> update</a> | <a href='${pageContext.request.contextPath}/deleteCustomer?customerId=${theCustomer.customerId}' onClick="return confirm('Are you sure you want to delete?')"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M6.5 1.75a.25.25 0 01.25-.25h2.5a.25.25 0 01.25.25V3h-3V1.75zm4.5 0V3h2.25a.75.75 0 010 1.5H2.75a.75.75 0 010-1.5H5V1.75C5 .784 5.784 0 6.75 0h2.5C10.216 0 11 .784 11 1.75zM4.496 6.675a.75.75 0 10-1.492.15l.66 6.6A1.75 1.75 0 005.405 15h5.19c.9 0 1.652-.681 1.741-1.576l.66-6.6a.75.75 0 00-1.492-.149l-.66 6.6a.25.25 0 01-.249.225h-5.19a.25.25 0 01-.249-.225l-.66-6.6z"></path></svg> delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%@include file="footer.jsp" %>
