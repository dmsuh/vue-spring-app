export async function getAllHotels() {

    const response = await fetch('/api/hotels');
    return await response.json();
}

export async function createHotel(data) {
    const response = await fetch(`/api/hotel`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}
