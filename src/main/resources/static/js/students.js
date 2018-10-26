"use strict";

document.addEventListener("DOMContentLoaded", () => {
    $(function () {
        $('[data-toggle="popover"]').popover()
    })

    const emailLinks = document.getElementsByClassName("emailLinks");
    for (let link of emailLinks) {
        link.addEventListener("click", (e) => {
            const target = e.target;
        });
        link.addEventListener("dblclick", (e) => {
            const target = e.target;
            location = `mailto:${target.dataset.target}`;
        });
    }
});