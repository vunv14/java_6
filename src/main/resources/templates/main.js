
<!--Sử lí nút ADD-->
<script>
    const buyBtns = document.querySelector('.js-buy-add')
    const modal = document.querySelector('.modal1')
    const modalClose = document.querySelector('.js-buy-close')
    const modalCloseClose = document.querySelector('.js-buy-close-close')

    function showByAdd() {
    modal.classList.add('open')
}

    buyBtns.addEventListener('click', showByAdd)


    function showByClose() {
    modal.classList.remove('open')
}




    modalClose.addEventListener('click', showByClose)
    modalCloseClose.addEventListener('click', showByClose)
</script>


<!--Sử lí nút Con Mắt-->
<script>
    const modalEye = document.querySelector('.js-buy-eye')
    const modalRemove = document.querySelector('.modal--remove')
    const modalCloseEye = document.querySelector('.js-buy-close-eye')
    const modalCloseCloseEye = document.querySelector('.js-buy-close-close-eye')
    function showByEye() {
    modalRemove.classList.add('open')
}

    function showByCloseRemove() {
    modalRemove.classList.remove('open')
}

    modalEye.addEventListener('click', showByEye)
    modalCloseEye.addEventListener('click', showByCloseRemove)
    modalCloseCloseEye.addEventListener('click',showByCloseRemove)
</script>
<!--Sư lí nút pencil -->
<script>
    const modalPencil = document.querySelector('.js-buy-pencil')
    const modalUpdate = document.querySelector('.modal--update')
    const modalClosePencil = document.querySelector('.js-buy-close-pencil')
    const modalCloseClosePencil = document.querySelector('.js-buy-close-close-pencil')
    function showByPencil() {
    modalUpdate.classList.add('open')
}

    function showByCloseUpdate() {
    modalUpdate.classList.remove('open')
}

    modalPencil.addEventListener('click', showByPencil)
    modalClosePencil.addEventListener('click', showByCloseUpdate)
    modalCloseClosePencil.addEventListener('click',showByCloseUpdate)
</script>

