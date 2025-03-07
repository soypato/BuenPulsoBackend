
# **Guide to Using the Buen Pulso Backend API**

This API is designed to manage data related to users and their medical reports. Below, we show how to interact with the endpoints to create users, associate medical data, and perform other operations.

## **1. Create a Blood Type (BloodType)**

It is important to start by creating blood types before creating users because each user has a blood type associated with them, and blood types are of type **one to many** (one blood type can be associated with multiple users).

### **Endpoint:**
`POST /bloodTypes/new`

### **Description:**
This endpoint creates a new blood type.

### **Example JSON to create a blood type:**
```json
{
    "type": "O+"
}
```

---

## **2. Create a User (User)**

Once the blood type is created, we can proceed with creating the user. Make sure to include the `bloodTypeId` of the appropriate blood type.

### **Endpoint:**
`POST /users/new`

### **Description:**
This endpoint creates a new user. Be sure to include the `bloodTypeId` for the corresponding blood type.

### **Example JSON to create a user (ID 2):**
```json
{
    "name": "Juan",
    "surname": "Pérez",
    "nationality": "Argentinian",
    "birthdate": "1990-05-12",
    "gender": "Male",
    "phone": "+54123456789",
    "email": "juan.perez@gmail.com",
    "role": "user",
    "heightCm": 180.5,
    "weightKg": 75.3,
    "password": "password123",
    "bloodType": {
        "bloodTypeId": 1
    }
}
```

---

## **3. Create a Medical Report (Report)**

Once the user is created, you can associate a medical report, which contains information about blood pressure, glucose, blood oxygen, body temperature, among other things.

### **Endpoint:**
`POST /reports/new`

### **Description:**
This endpoint creates a new medical report for a specific user.

### **Example JSON to create a medical report (ID 2):**
```json
{
    "user": {
        "idUser": 2
    },
    "systolicPressure": 120,
    "diastolicPressure": 80,
    "beatsPerMinute": 72,
    "glucose": 90,
    "bloodOxygen": 98,
    "bodyTemperature": 36.5,
    "mood": "Normal",
    "registrationDate": "2025-03-07"
}
```

---

## **4. Create a Medication (Medications)**

If a user is taking any medications, you can add it using this endpoint.

### **Endpoint:**
`POST /medications/new`

### **Description:**
This endpoint creates a new medication for a user.

### **Example JSON to add medication (ID 2):**
```json
{
    "user": {
        "idUser": 2
    },
    "medicationName": "Ibuprofen",
    "dose": "500mg",
    "frequency": "Twice a day",
    "startDate": "2025-03-01",
    "endDate": "2025-03-15"
}
```

---

## **5. Create a Chronic Disease (ChronicDiseases)**

If a user has a chronic disease, you can add it to their medical history using this endpoint.

### **Endpoint:**
`POST /chronicDiseases/new`

### **Description:**
This endpoint adds a chronic disease to a user.

### **Example JSON to add a chronic disease (ID 2):**
```json
{
    "user": {
        "idUser": 2
    },
    "disease": "Hypertension",
    "diagnosticDate": "2020-06-15"
}
```

---

## **6. Create a Known Allergy (KnownAllergies)**

If a user has any known allergies, you can add them to their medical history using this endpoint.

### **Endpoint:**
`POST /knownAllergies/new`

### **Description:**
This endpoint adds a known allergy to a user.

### **Example JSON to add an allergy (ID 2):**
```json
{
    "user": {
        "idUser": 2
    },
    "allergy": "Pollen",
    "date": "2025-03-07"
}
```

---

## **7. Modify a User (PUT /users/edit/{id})**

If you need to modify a user’s data, you can do it using this endpoint.

### **Endpoint:**
`PUT /users/edit/{id}`

### **Description:**
This endpoint allows you to modify an existing user by specifying their `idUser`.

### **Example JSON to modify a user (ID 2):**
```json
{
    "name": "Juan Carlos",
    "surname": "Pérez",
    "nationality": "Argentinian",
    "birthdate": "1990-05-12",
    "gender": "Male",
    "phone": "+54123456789",
    "email": "juan.perez@gmail.com",
    "role": "user",
    "heightCm": 182,
    "weightKg": 76,
    "password": "newpassword123",
    "bloodType": {
        "bloodTypeId": 1
    }
}
```

---

## **8. Delete a User (DELETE /users/delete/{id})**

If you need to delete a user, you can do it with this endpoint.

### **Endpoint:**
`DELETE /users/delete/{id}`

### **Description:**
This endpoint deletes a user by their `idUser`.

### **Example of deleting a user (ID 2):**
```json
{
    "message": "User deleted successfully"
}
```

---

## **Final Considerations:**
- **Creation sequence:** First create **blood types**, then create **users**, and finally you can add **medical reports**, **medication**, **chronic diseases**, and **known allergies**.
- **References:** Be sure to use the `id` generated for blood types and users as foreign keys when creating related entities.
- **Date format:** The date should be in the format `YYYY-MM-DD` (e.g., `"2025-03-07"`).

---

Now you have all the necessary information to interact with the API. If you have any further questions or need more examples, feel free to ask. Good luck with the implementation!