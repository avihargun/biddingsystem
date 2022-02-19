
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <form>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="text" class="form-control" name="EventTitle" id="EventTitle" placeholder="EventTitle">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Start Date</label>
                <input type="date" class="form-control" id="startDate" name="startDate" placeholder="dd/mm/yyyy">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="startTime">Start Time</label>
                <input type="time" class="form-control" name="startTime" id="startTime" >
            </div>
            <div class="form-group col-md-6">
                <label for="duration">Duration</label>
                <input type="text" class="form-control" id="duration" name="duration" placeholder="10">
            </div>
        </div>
        <div class="form-group">
            <label for="inputAddress2">Address 2</label><br>
            <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputCity">City</label>
                <input type="text" class="form-control" id="inputCity">
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">Catagory</label>
                <select id="inputState" class="form-control">
                    <option selected>Choose...</option>
                    <option>Arts and Antiques</option>
                    <option>Jwellery</option>
                    <option>Vehicales </option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="inputZip">Zip</label>
                <input type="text" class="form-control" id="inputZip">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form> 
</body>
</html>