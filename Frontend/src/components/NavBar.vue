<template>
    <div className="container-nav">
        <div className="container-content">
            <img src="../assets/logo-sistema.png" alt="">
            <span>Sistema de Emergencias<span>Región Metropolitana</span></span>
        </div>
        <div className="container-content">
            <img src="../assets/logo-usach.png" alt="">
        </div>
    </div>
</template>

<style>

.container-nav {
    display: flex;
    justify-content: space-around;
    padding: 5px 0;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
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