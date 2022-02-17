<html>

<head>
    <title>Javascript Login Form Validation</title>
    <!-- Include CSS File Here -->
    <link rel="stylesheet" href="/css/style.css" />
    <!-- Include JS File Here -->

</head>

<body>
    <div class="container">
        <div class="main">
            <h2>Sign Up for Auctioneer</h2>
            <form id="signup" method="post" name="signup" action="http://localhost:9192/signup">
                <label>Seller Id :</label>
                <input type="email" name="email" id="email" />
                <label>AuctionHouse Name :</label>
                <input type="text" name="houseName" id="houseName" />
                <label>Address :</label>
                <input type="text" name="address" id="address" />
                <label>Contact :</label>
                <input type="text" name="contact" id="contact" />
                <label>Password :</label>
                <input type="password" name="password" id="password" />
                <input type="submit" value="SignUp">
            </form>
            <!-- <span><b class="note">Note : </b>For this demo use following username and password. <br /><b
                    class="valid">User Name : Formget<br />Password : formget#123</b></span> -->
        </div>
    </div>
</body>

</html>