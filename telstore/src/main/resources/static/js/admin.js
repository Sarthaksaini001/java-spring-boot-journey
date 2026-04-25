function showMessage(message, type = "success") {
    const messageDiv = document.getElementById("message");
    messageDiv.innerHTML = `
        <div class="alert alert-${type} alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    `;
}

async function loadAdminProducts() {
    const container = document.getElementById("admin-product-list");
    const response = await fetch("/products");
    const products = await response.json();

    container.innerHTML = "";

    products.forEach(product => {
        container.innerHTML += `
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5>${product.name}</h5>
                        <p>${product.brand}</p>
                        <p>$${product.price}</p>
                        <button class="btn btn-warning btn-sm" onclick="fillProductForm(${product.id})">Edit</button>
                        <button class="btn btn-danger btn-sm" onclick="deleteProduct(${product.id})">Delete</button>
                    </div>
                </div>
            </div>
        `;
    });
}

async function loadAdminPlans() {
    const container = document.getElementById("admin-plan-list");
    const response = await fetch("/plans");
    const plans = await response.json();

    container.innerHTML = "";

    plans.forEach(plan => {
        container.innerHTML += `
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5>${plan.name}</h5>
                        <p>${plan.planType}</p>
                        <p>$${plan.monthlyPrice}/month</p>
                        <button class="btn btn-warning btn-sm" onclick="fillPlanForm(${plan.id})">Edit</button>
                        <button class="btn btn-danger btn-sm" onclick="deletePlan(${plan.id})">Delete</button>
                    </div>
                </div>
            </div>
        `;
    });
}

async function deleteProduct(id) {
    if (!confirm("Delete this product?")) return;

    const response = await fetch(`/products/${id}`, {
        method: "DELETE"
    });

    if (response.ok) {
        showMessage("Product deleted successfully!");
        loadAdminProducts();
    } else {
        showMessage("Failed to delete product.", "danger");
    }
}

async function deletePlan(id) {
    if (!confirm("Delete this plan?")) return;

    const response = await fetch(`/plans/${id}`, {
        method: "DELETE"
    });

    if (response.ok) {
        showMessage("Plan deleted successfully!");
        loadAdminPlans();
    } else {
        showMessage("Failed to delete plan.", "danger");
    }
}

async function fillProductForm(id) {
    const response = await fetch(`/products/${id}`);
    const product = await response.json();

    document.getElementById("product-id").value = product.id;
    document.getElementById("product-name").value = product.name;
    document.getElementById("product-brand").value = product.brand;
    document.getElementById("product-description").value = product.description;
    document.getElementById("product-price").value = product.price;
    document.getElementById("product-category").value = product.category;
    document.getElementById("product-image").value = product.imageUrl;
    document.getElementById("product-stock").value = product.stockQuantity;
}

async function fillPlanForm(id) {
    const response = await fetch(`/plans/${id}`);
    const plan = await response.json();

    document.getElementById("plan-id").value = plan.id;
    document.getElementById("plan-name").value = plan.name;
    document.getElementById("plan-type").value = plan.planType;
    document.getElementById("plan-price").value = plan.monthlyPrice;
    document.getElementById("plan-data").value = plan.dataLimit;
    document.getElementById("plan-calls").value = plan.callsIncluded;
    document.getElementById("plan-sms").value = plan.smsIncluded;
    document.getElementById("plan-description").value = plan.description;
}

document.getElementById("product-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const productId = document.getElementById("product-id").value;

    const product = {
        name: document.getElementById("product-name").value,
        brand: document.getElementById("product-brand").value,
        description: document.getElementById("product-description").value,
        price: Number(document.getElementById("product-price").value),
        category: document.getElementById("product-category").value,
        imageUrl: document.getElementById("product-image").value,
        stockQuantity: Number(document.getElementById("product-stock").value)
    };

    const url = productId ? `/products/${productId}` : "/products";
    const method = productId ? "PUT" : "POST";

    const response = await fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product)
    });

    if (response.ok) {
        this.reset();
        document.getElementById("product-id").value = "";
        showMessage(productId ? "Product updated successfully!" : "Product added successfully!");
        loadAdminProducts();
    } else {
        showMessage("Failed to save product.", "danger");
    }
});

document.getElementById("plan-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const planId = document.getElementById("plan-id").value;

    const plan = {
        name: document.getElementById("plan-name").value,
        planType: document.getElementById("plan-type").value,
        monthlyPrice: Number(document.getElementById("plan-price").value),
        dataLimit: document.getElementById("plan-data").value,
        callsIncluded: document.getElementById("plan-calls").value,
        smsIncluded: document.getElementById("plan-sms").value,
        description: document.getElementById("plan-description").value
    };

    const url = planId ? `/plans/${planId}` : "/plans";
    const method = planId ? "PUT" : "POST";

    const response = await fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(plan)
    });

    if (response.ok) {
        this.reset();
        document.getElementById("plan-id").value = "";
        showMessage(planId ? "Plan updated successfully!" : "Plan added successfully!");
        loadAdminPlans();
    } else {
        showMessage("Failed to save plan.", "danger");
    }
});

loadAdminProducts();
loadAdminPlans();