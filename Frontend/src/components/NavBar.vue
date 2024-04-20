<template>
    <div class="container-nav">
        <div class="container-content">
            <img src="../assets/logo-sistema.png" alt="">
            <span>Sistema de Emergencias<span>Región Metropolitana</span></span>
        </div>
        <div class="container-content">
            <img src="../assets/logo-usach.png" alt="">
        </div>
    </div>
</template>

<style scoped>

.container-nav {
    display: flex;
    justify-content: space-around;
    padding: 5px 0;
    border-bottom: 1px solid whitesmoke;
}

.container-content {
    display: flex;
    align-items: center;
    gap: 30px;
}

img {
    height: 80px;
}

span {
    display: flex;
    flex-direction: column;
    text-transform: uppercase;
    font-size: 1.5rem;
    font-weight: bold;
}

span:first-child {
    font-size: 1.1rem;
    letter-spacing: 5px; 
}

</style>