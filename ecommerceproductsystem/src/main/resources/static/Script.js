const API = "http://localhost:8080/products";

// Fetch all products
async function getProducts() {
    const res = await fetch(API);
    const data = await res.json();

    const list = document.getElementById("list");
    list.innerHTML = "";

    data.forEach(p => {
        list.innerHTML += `
            <li>
                ${p.name} - ₹${p.price}
                <button onclick="deleteProduct(${p.id})">Delete</button>
            </li>
        `;
    });
}

// Add product
async function addProduct() {
    const name = document.getElementById("name").value;
    const price = document.getElementById("price").value;

    await fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, price })
    });

    getProducts();
}

// Delete product
async function deleteProduct(id) {
    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });

    getProducts();
}

// Load data on start
getProducts();