<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update form</title>
</head>
<body>
  
<jsp:include page="modules/header.jsp"></jsp:include> 

   
        <div class="row">
    <div class="col-lg-12 p-5">
        <div class="card">
            <div class="card-header border-bottom border-dashed d-flex align-items-center">
                <h4 class="header-title">User</h4>
            </div>

            <div class="card-body">
                <p class="text-muted">Please fill in the details below to create your account.</p>
                <form class="needs-validation" action="userUpdate" novalidate>
                    <div class="mb-3">
                        <label class="form-label" for="firstName">Id</label>
                        <input type="number" class="form-control" name="id"  id="UserId" placeholder="User Id" required>
                        <div class="valid-feedback">Looks good!</div>
                        <div class="invalid-feedback">Please enter your Id.</div>
                    </div>
                    
                       <div class="mb-3">
                        <label class="form-label" for="firstName">First Name</label>
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First name" required>
                        <div class="valid-feedback">Looks good!</div>
                        <div class="invalid-feedback">Please enter your first name.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="lastName">Last Name</label>
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name" required>
                        <div class="valid-feedback">Looks good!</div>
                        <div class="invalid-feedback">Please enter your last name.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="email">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="Email address" required>
                        <div class="invalid-feedback">Please enter a valid email address.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="phone">Phone Number</label>
                        <input type="tel" class="form-control" name="phone" id="phone" placeholder="Phone number" required>
                        <div class="invalid-feedback">Please enter a valid phone number.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                        <div class="invalid-feedback">Password must be at least 6 characters.</div>
                    </div>



                    <div class="mb-3">
                        <label class="form-label" for="address">Address</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Street address" required>
                        <div class="invalid-feedback">Please enter your address.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="city">City</label>
                        <input type="text" class="form-control" name="city" id="city" placeholder="City" required>
                        <div class="invalid-feedback">Please enter your city.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="state">State</label>
                        <input type="text" class="form-control" name="state" id="state" placeholder="State" required>
                        <div class="invalid-feedback">Please enter your state.</div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="zip">Zip Code</label>
                        <input type="text" class="form-control"name="zip" id="zip" placeholder="Zip Code" required>
                        <div class="invalid-feedback">Please enter a valid zip code.</div>
                    </div>

                    <div class="mb-3">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="termsCheck" required>
                            <label class="form-check-label form-label" for="termsCheck">I agree to the terms and conditions</label>
                            <div class="invalid-feedback">You must agree before submitting.</div>
                        </div>
                    </div>

                    <button class="btn btn-primary" type="submit">Update</button>
                </form>
            </div> 
        </div> 
    </div>
</div>



<jsp:include page="modules/footer.jsp"></jsp:include>
</body>
</html>