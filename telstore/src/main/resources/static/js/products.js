let allPlans = [];

async function loadPlansForBundle() {
    try {
        const response = await fetch("/plans");
        allPlans = await response.json();
    } catch (error) {
        console.error("Failed to load plans for bundle", error);
    }
}

async function loadProducts() {
    const productList = document.getElementById("product-list");

    try {
        const response = await fetch("/products");
        const products = await response.json();

        productList.innerHTML = "";

        products.forEach(product => {
            const card = document.createElement("div");
            card.className = "col-md-4";

            const planOptions = allPlans.map(plan => `
                <option value="${plan.id}">${plan.name} - $${plan.monthlyPrice}</option>
            `).join("");

            card.innerHTML = `
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <h6 class="text-muted">${product.brand}</h6>
                        <p class="card-text">${product.description}</p>
                        <p><strong>Category:</strong> ${product.category}</p>
                        <p><strong>Price:</strong> $${product.price}</p>
                        <p><strong>Stock:</strong> ${product.stockQuantity}</p>

                        <button class="btn btn-primary mb-3" onclick="addProductToCart(${product.id})">
                            Add Product Only
                        </button>

                        <div class="mt-3">
                            <label class="form-label"><strong>Select Plan for Bundle</strong></label>
                            <select class="form-select mb-2" id="plan-select-${product.id}">
                                <option value="">Choose a plan</option>
                                ${planOptions}
                            </select>
                            <button class="btn btn-dark" onclick="addBundleToCart(${product.id})">
                                Add Bundle
                            </button>
                        </div>
                    </div>
                </div>
            `;

            productList.appendChild(card);
        });
    } catch (error) {
        productList.innerHTML = `<p class="text-danger">Failed to load products.</p>`;
        console.error(error);
    }
}

async function addProductToCart(productId) {
    const cartId = localStorage.getItem("cartId");

    if (!cartId) {
        alert("No cart found. Please create a cart first from the cart page.");
        return;
    }

    try {
        const response = await fetch(`/carts/${cartId}/items`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                productId: productId,
                planId: null,
                quantity: 1
            })
        });

        if (response.ok) {
            alert("Product added to cart!");
        } else {
            const errorData = await response.json();
            alert(errorData.message || "Failed to add product.");
        }
    } catch (error) {
        console.error(error);
        alert("Error adding product.");
    }
}

async function addBundleToCart(productId) {
    const cartId = localStorage.getItem("cartId");
    const selectedPlanId = document.getElementById(`plan-select-${productId}`).value;

    if (!cartId) {
        alert("No cart found. Please create a cart first from the cart page.");
        return;
    }

    if (!selectedPlanId) {
        alert("Please select a plan first.");
        return;
    }

    try {
        const response = await fetch(`/carts/${cartId}/items`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                productId: productId,
                planId: Number(selectedPlanId),
                quantity: 1
            })
        });

        if (response.ok) {
            alert("Bundle added to cart!");
        } else {
            const errorData = await response.json();
            alert(errorData.message || "Failed to add bundle.");
        }
    } catch (error) {
        console.error(error);
        alert("Error adding bundle.");
    }
}

async function initProductsPage() {
    await loadPlansForBundle();
    await loadProducts();
}

initProductsPage();