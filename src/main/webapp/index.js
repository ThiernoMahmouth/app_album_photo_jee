let products = [
    ['images/shop/product/s1.jpg','images/shop/product/s-1.jpg','Branded T-Shirt','$16.00','$21.50'],
    ['images/shop/product/s2.jpg','images/shop/product/s-2.jpg','Shopping Bag','$21.00','$25.00'],
    ['images/shop/product/s3.jpg','images/shop/product/s-3.jpg','Elegent Watch','$4.00','$5.00'],
    ['images/shop/product/s4.jpg','images/shop/product/s-4.jpg','BackPack','$18.00','$22.00'],
    ['images/shop/product/s5.jpg','images/shop/product/s-5.jpg','Earphones','$10.00','$15.00'],
    ['images/shop/product/s6.jpg','images/shop/product/s-6.jpg','Elegent Mug','$4.50','$6.50'],
    ['images/shop/product/s7.jpg','images/shop/product/s-7.jpg','Sonny Headphones','$9.00','$12.00'],
    ['images/shop/product/s8.jpg','images/shop/product/s-8.jpg','Wooden tools','$22.00','$25.00'],
    ['images/shop/product/s9.jpg','images/shop/product/s-9.jpg','Coffee Cup / Mug','$16.00','$22.00'],
    ['images/shop/product/s10.jpg','images/shop/product/s-10.jpg','Sunglasses','$21.00','$25.00'],
    ['images/shop/product/s11.jpg','images/shop/product/s-11.jpg','Loafer shoes','$5.00','$7.00'],
    ['images/shop/product/s12.jpg','images/shop/product/s-12.jpg','T-shirts','$18.00','$22.00'],
    ['images/shop/product/s13.jpg','images/shop/product/s-13.jpg','Wooden chair','$16.00','$21.00'],
    ['images/shop/product/s14.jpg','images/shop/product/s-14.jpg','Women black heels','$21.00','$25.00'],
    ['images/shop/product/s15.jpg','images/shop/product/s-15.jpg','T-shirts','$5.00','$6.00'],
    ['images/shop/product/s16.jpg','images/shop/product/s-16.jpg','T-shirts','$18.00','$22.00']
]

function header()
{
    let header = document.createElement('header')
    header.setAttribute('class','defaultscroll sticky')
    let container = document.createElement('div')
    container.setAttribute('class','container')
        // sous element 1: logo
        let logo = document.createElement('div')
        let a = document.createElement('a')
        a.setAttribute('class','logo')
        a.setAttribute('href','index.jsp')

        let img = document.createElement('img')
        img.setAttribute('src','images/logo-dark.png')
        img.setAttribute('height','24')
        img.setAttribute('alt','Logo')
        a.appendChild(img)

        logo.appendChild(a)
        //ajout au container
        container.appendChild(logo)

        // sous element 2: ul à droite
        let ul = document.createElement('ul')
        ul.setAttribute('class','buy-button list-inline mb-0')
         
            //element 2
            let li2 = document.createElement('li')
            li2.setAttribute('class','list-inline-item mb-0 pr-1')
            li2.innerHTML = `<a href="register" class="btn btn-primary">Inscription/Connexion</a>` 
            ul.appendChild(li2)
			/*
            //element 3
            let li3 = document.createElement('li')
            li3.setAttribute('class','list-inline-item mb-0 pr-1')
            li3.innerHTML = `
                <a href="#" class="btn btn-icon btn-primary" data-toggle="modal" data-target="#wishlist"><i class="uil uil-heart align-middle icons"></i></a>
            `
            ul.appendChild(li3)

            // element 4
            let li4 = document.createElement('li')
            li4.setAttribute('class','list-inline-item mb-0')
            li4.innerHTML = `
                <div class="dropdown dropdown-primary">
                    <button type="button" class="btn btn-icon btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="uil uil-user align-middle icons"></i></button>
                    <div class="dropdown-menu dd-menu dropdown-menu-right bg-white shadow rounded border-0 mt-3 py-3" style="width: 200px;">
                        <a class="dropdown-item text-dark" href="shop-myaccount.html"><i class="uil uil-user align-middle mr-1"></i>My Account</a>
                        <a class="dropdown-item text-dark" href="#"><i class="uil uil-clipboard-notes align-middle mr-1"></i> Order History</a>
                        <div class="dropdown-divider my-3 border-top"></div>
                        <a class="dropdown-item text-dark" href="#"><i class="uil uil-sign-out-alt align-middle mr-1"></i> Logout</a>
                    </div>
                </div>
            `
            ul.appendChild(li4)
		*/
        //ajout au container
        container.appendChild(ul)

        //sous element 3: menu-extras
        let menu_extras=  document.createElement('div')
        menu_extras.setAttribute('class','menu-extras')
            let menu_item = document.createElement('div')
            menu_item.setAttribute('class','menu-item')
            menu_item.innerHTML = `
            <a class="navbar-toggle">
                <div class="lines">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </a>
            `
            menu_extras.appendChild(menu_item)

        //ajout au container
        container.appendChild(menu_extras)

        //sous element 4: navigation
        let navigation = document.createElement('div')
        navigation.setAttribute('id','navigation')
            let navul = document.createElement('ul')
            navul.setAttribute('class','navigation-menu')
            let menus = [
                ['Home.html','Home'],
                ['shop-grids.html','Products'],
                ['page-contact-detail.html','Contact']
            ];
            menus.forEach((menu)=>{
                let li = document.createElement('li')
                let a = document.createElement('a')
                a.setAttribute('href',`${menu[0]}`)
                a.innerText = `${menu[1]}`
                li.appendChild(a)
                navul.appendChild(li)
            })

            navigation.appendChild(navul)
        //ajout au container
        container.appendChild(navigation)
    header.appendChild(container)
    header.setAttribute('id','topnav')
    return header
}

function footer(){
    return `
    <footer class="footer footer-bar">
        <div class="container text-center">
            <div class="row align-items-center">
                <div class="col-sm-6">
                    <div class="text-sm-left">
                        <p class="mb-0">© <script>document.write(new Date().getFullYear())</script> DIC3 INFO Design with <i class="mdi mdi-heart text-danger"></i> by <a href="#" class="text-reset">TMD&GK&MMK</a>.</p>
                    </div>
                </div><!--end col-->
            </div><!--end row-->
        </div><!--end container-->
    </footer><!--end footer-->
    `
}


function buildContenu()
{
    let container = document.createElement('div')
    container.setAttribute('class','contenuPrincipal')
    // sous element 1
    let container_elt1 = document.createElement('section')
    container_elt1.setAttribute('class','main-slider')
        // sous sous element 1
        let container_elt1_1 = document.createElement('ul')
        container_elt1_1.setAttribute('class','slides')
        let sliders=[
            ['images/shop/bg2.jpg','Evènements','Fêtes'],
            ['images/shop/bg1.jpg','Voyage','Escapade'],
            ['images/shop/bg3.jpg','Quotidien','Rencontres'],
        ]
        sliders.forEach((slider)=>{
            let container_elt1_1_1 = document.createElement('li')
            container_elt1_1_1.setAttribute('class','bg-slider slider-rtl-3 d-flex align-items-center')
            container_elt1_1_1.setAttribute('style',`background:url('${slider[0]}') center center;`)
            container_elt1_1_1.innerHTML = `
                <div class="container">
                    <div class="row align-items-center mt-5">
                        <div class="col-lg-7 col-md-7">
                            <div class="title-heading mt-4">
                                <h1 class="display-4 title-white font-weight-bold mb-3">${slider[1]}, <br> ${slider[2]}</h1>
                                <p class="para-desc text-muted para-dark">
								Avec Photo ESP, gardez les souvenirs de vos rencontres, voyages ... <br/> Partagez-les avec le Monde!
								</p>
                                <div class="mt-4">
                                    <a href="register" class="btn btn-soft-primary">Inscrivez-vous!</a>
                                </div>
                            </div>
                        </div><!--end col-->
                    </div><!--end row-->
                </div>
            `
            container_elt1_1.appendChild(container_elt1_1_1)
        })
        container_elt1.appendChild(container_elt1_1)
    container.appendChild(container_elt1)
    return container;
}

function homePage()
{
    let container =  document.createElement('div')
    container.setAttribute('class','contenuPrincipal')
    // element 1 de la page
    let container_elt1 = document.createElement('div')
    container_elt1.setAttribute('class','container-fluid mt-5 pt-2')
    // sous element 1 de l'element 1
    let container_elt1_1 = document.createElement('div')
    container_elt1_1.setAttribute('class','mt-5')
    container_elt1.appendChild(container_elt1_1)

    //sous-element2 de lelement 1
    let container_elt1_2 = document.createElement('div')
    container_elt1_2.setAttribute('class','row')
    for (let i = 1; i <= 3; i++) 
	{
        let container_elt1_2_1 = document.createElement('div')
        container_elt1_2_1.setAttribute('class','col-md-4')
        container_elt1_2_1.innerHTML = `
            <div class="py-5 rounded shadow" style="background: url('images/shop/fea${i}.jpg') top center;">
                <div class="p-4">
                    <h3>Summer <br> Collection</h3>
                    <a href="javascript:void(0)" class="btn btn-sm btn-soft-primary mt-2">Shop Now</a>
                </div>
            </div>
        `
        container_elt1_2.appendChild(container_elt1_2_1)
        
    }

    container_elt1.appendChild(container_elt1_2)

    //ajout de l'element 1 au contenu principal
    container.appendChild(container_elt1)

    //element 2 de la page
    let container_elt2 = document.createElement('section')
    container_elt2.setAttribute('class','section')
    // sous element 1
    let container_elet2_1 = document.createElement('div')
    container_elet2_1.setAttribute('class','container')
        //sous-sous-element 1
        let container_elet2_1_1 = document.createElement('div')
        container_elet2_1_1.setAttribute('class','row')
        container_elet2_1_1.innerHTML=`
            <div class="col-12">
                <h5 class="mb-0">Most Viewed Products</h5>
            </div>
        `
        container_elet2_1.appendChild(container_elet2_1_1)
        //sous-sous-element 2
        let container_elet2_1_2 = document.createElement('div')
        container_elet2_1_2.setAttribute('class','row')
        for (let i = 0; i < 8; i++) {
            let container_elet2_1_2_1 = document.createElement('div')
            container_elet2_1_2_1.setAttribute('class','col-lg-3 col-md-6 col-12 mt-4 pt-2')
            container_elet2_1_2_1.innerHTML = `
            <div class="card shop-list border-0 position-relative">
                <div class="shop-image position-relative overflow-hidden rounded shadow">
                    <a href="shop-product-detail.html"><img src="${products[i][0]}" class="img-fluid" alt=""></a>
                    <a href="shop-product-detail.html" class="overlay-work">
                        <img src="${products[i][1]}" class="img-fluid" alt="">
                    </a>
                </div>
                <div class="card-body content pt-4 p-2">
                    <a href="shop-product-detail.html" class="text-dark product-name h6">${products[i][2]}</a>
                    <div class="d-flex justify-content-between mt-1">
                        <h6 class="text-muted small font-italic mb-0 mt-1">${products[i][3]} <del class="text-danger ml-2">${products[i][4]}</del> </h6>
                        <ul class="list-unstyled text-warning mb-0">
                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            `
              container_elet2_1_2.appendChild(container_elet2_1_2_1)    
        }
        container_elet2_1.appendChild(container_elet2_1_2)
    container_elt2.appendChild(container_elet2_1)
    //sous element 2
    let container_elt2_2 = document.createElement('div')
    container_elt2_2.setAttribute('class','container mt-100 mt-60')
        //sous sous element 1
        let container_elt2_2_1 = document.createElement('div')
        container_elt2_2_1.setAttribute('class','row')
        container_elt2_2_1.innerHTML = `
            <div class="col-12">
                <h5 class="mb-0">Top Categories</h5>
            </div>
        `
        container_elt2_2.appendChild(container_elt2_2_1)
        //sous sous element2
        let container_elt2_2_2 = document.createElement('div')
        container_elt2_2_2.setAttribute('class','row')
        let categories = ['fashion','sports','music','furniture','electronics','mobile']
        categories.forEach((categorie)=>{
            let container_elt2_2_2_1 = document.createElement('div')
            container_elt2_2_2_1.setAttribute('class','col-lg-2 col-md-4 col-6 mt-4 pt-2')
            container_elt2_2_2_1.innerHTML = `
                <div class="card explore-feature border-0 rounded text-center bg-white">
                    <div class="card-body">
                        <img src="images/shop/categories/${categorie}.jpg" class="avatar avatar-small rounded-circle shadow-md" alt="">
                        <div class="content mt-3">
                            <h6 class="mb-0"><a href="javascript:void(0)" class="title text-dark">${categorie}</a></h6>
                        </div>
                    </div>
                </div>
            `
            container_elt2_2_2.appendChild(container_elt2_2_2_1)
        })
        container_elt2_2.appendChild(container_elt2_2_2)

    container_elt2.appendChild(container_elt2_2)
    
    // sous element 3
    let container_elt2_3 = document.createElement('div')
    container_elt2_3.setAttribute('class','container mt-100 mt-60')
        //sous sous element1 
        let container_elt2_3_1 = document.createElement('div')
        container_elt2_3_1.setAttribute('class','row')
        container_elt2_3_1.innerHTML = `
            <div class="col-12">
                <h5 class="mb-0">Popular Products</h5>
            </div>
        `
        container_elt2_3.appendChild(container_elt2_3_1)
        // sous sous element 2
        let container_elt2_3_2 = document.createElement('div')
        container_elt2_3_2.setAttribute('class','row')
        for (let i = 8; i <= 11; i++) {
            let container_elt2_3_2_1 = document.createElement('div')
            container_elt2_3_2_1.setAttribute('class','col-lg-3 col-md-6 col-12 mt-4 pt-2')
            container_elt2_3_2_1.innerHTML = `
                <div class="card shop-list border-0 position-relative">
                    <ul class="label list-unstyled mb-0">
                        <li><a href="javascript:void(0)" class="badge badge-pill badge-info">Popular</a></li>
                    </ul>
                    <div class="shop-image position-relative overflow-hidden rounded shadow">
                        <a href="shop-product-detail.html"><img src="${products[i][0]}" class="img-fluid" alt=""></a>
                        <a href="shop-product-detail.html" class="overlay-work">
                            <img src="${products[i][1]}" class="img-fluid" alt="">
                        </a>
                    </div>
                    <div class="card-body content pt-4 p-2">
                        <a href="shop-product-detail.html" class="text-dark product-name h6">${products[i][2]}</a>
                        <div class="d-flex justify-content-between mt-1">
                            <h6 class="text-muted small font-italic mb-0 mt-1">${products[i][3]} <del class="text-danger ml-2">${products[i][4]}</del> </h6>
                            <ul class="list-unstyled text-warning mb-0">
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                            </ul>
                        </div>
                    </div>
                </div>
            `
            container_elt2_3_2.appendChild(container_elt2_3_2_1)
            
        }
        container_elt2_3.appendChild(container_elt2_3_2)

    container_elt2.appendChild(container_elt2_3)

    // sous element 4
    let container_elt2_4 = document.createElement('div')
    container_elt2_4.setAttribute('class','container-fluid mt-100 mt-60')
        // sous sous element 1
        let container_elt2_4_1 = document.createElement('div')
        container_elt2_4_1.setAttribute('class','rounded py-5')
        container_elt2_4_1.setAttribute('style','background: url("images/shop/cta.jpg") fixed;')
        container_elt2_4_1.innerHTML = `
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="section-title">
                            <h2 class="font-weight-bold mb-4">End of Season Clearance <br> Sale upto 30%</h2>
                            <p class="para-desc para-white text-muted mb-0">Launch your campaign and benefit from our expertise on designing and managing conversion centered bootstrap4 html page.</p>
                            <div class="mt-4">
                                <a href="javascript:void(0)" class="btn btn-primary">Shop Now</a>
                            </div>
                        </div>
                    </div><!--end col-->
                </div><!--end row-->
            </div>
        `
        container_elt2_4.appendChild(container_elt2_4_1)
    
    container_elt2.appendChild(container_elt2_4)
    
    // sous element 5
    let container_elt2_5 = document.createElement('div')
    container_elt2_5.setAttribute('class','container mt-100 mt-60')
        //sous sous element1 
        let container_elt2_5_1 = document.createElement('div')
        container_elt2_5_1.setAttribute('class','row')
        container_elt2_5_1.innerHTML = `
            <div class="col-12">
                <h5 class="mb-0">Recent Products</h5>
            </div>
        `
        container_elt2_5.appendChild(container_elt2_5_1)
        // sous sous element 2
        let container_elt2_5_2 = document.createElement('div')
        container_elt2_5_2.setAttribute('class','row')
        for (let i = 12; i < 16; i++)
		{
            let container_elt2_5_2_1 = document.createElement('div')
            container_elt2_5_2_1.setAttribute('class','col-lg-3 col-md-6 col-12 mt-4 pt-2')
            container_elt2_5_2_1.innerHTML = `
                <div class="card shop-list border-0 position-relative">
                    <ul class="label list-unstyled mb-0">
                        <li><a href="javascript:void(0)" class="badge badge-pill badge-primary">New</a></li>
                    </ul>
                    <div class="shop-image position-relative overflow-hidden rounded shadow">
                        <a href="shop-product-detail.html"><img src="${products[i][0]}" class="img-fluid" alt=""></a>
                        <a href="shop-product-detail.html" class="overlay-work">
                            <img src="${products[i][1]}" class="img-fluid" alt="">
                        </a>
                    </div>
                    <div class="card-body content pt-4 p-2">
                        <a href="shop-product-detail.html" class="text-dark product-name h6">${products[i][2]}</a>
                        <div class="d-flex justify-content-between mt-1">
                            <h6 class="text-muted small font-italic mb-0 mt-1">${products[i][3]} <del class="text-danger ml-2">${products[i][4]}</del> </h6>
                            <ul class="list-unstyled text-warning mb-0">
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                            </ul>
                        </div>
                    </div>
                </div>
            `
            container_elt2_5_2.appendChild(container_elt2_5_2_1)
        }
        container_elt2_5.appendChild(container_elt2_5_2)

    container_elt2.appendChild(container_elt2_5)

    //ajout de l'element 2 au contenu principal
    container.appendChild(container_elt2)
    return container
}

function productPage()
{
    // contenu principal
    let container = document.createElement('div')
    container.setAttribute('class','contenuPrincipal')

    // section 1
    let section1 = document.createElement('section')
    section1.setAttribute('class','bg-half bg-light d-table w-100')

    let div = document.createElement('div')
    div.setAttribute('class','container')
    div.innerHTML += ` 
        <div class="row justify-content-center">
            <div class="col-lg-12 text-center">
                <div class="page-next-level">
                    <h4 class="title"> Gallerie publique </h4>
                    <div class="page-next">
                        <nav aria-label="breadcrumb" class="d-inline-block">
                            <ul class="breadcrumb bg-white rounded shadow mb-0">
                                <li class="breadcrumb-item">Phot ESP</li>
                                <li class="breadcrumb-item active" aria-current="page">Public</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div><!--end col-->
        </div>
    `
    section1.appendChild(div)

    // div
    let div1 = document.createElement('div')
    div1.setAttribute('class','position-relative')
    let sousDiv1 = document.createElement('div');
    sousDiv1.setAttribute('class','shape overflow-hidden text-white')
    sousDiv1.innerHTML+= `
        <svg viewBox="0 0 2880 48" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M0 48H1437.5H2880V0H2160C1442.5 52 720 0 720 0H0V48Z" fill="currentColor"></path>
        </svg>
    `
    div1.appendChild(sousDiv1)

    //section 2
    let section2 = document.createElement('section');
    section2.setAttribute('class','section')

    let elt1 = document.createElement('div');
    elt1.setAttribute('class','container')

    let s_elt1 = document.createElement('div')
    s_elt1.setAttribute('class','row')
   
    //
    let row1 = document.createElement('div')
    row1.setAttribute('class','col-lg-3 col-md-4 col-12')

    let row1_elt1 = document.createElement('div')
    row1_elt1.setAttribute('class','card border-0 sidebar sticky-bar')

    let row1_elt1_elt1 = document.createElement('div')
    row1_elt1_elt1.setAttribute('class','card-body p-0')

    let row1_elt1_elt1_1 = document.createElement('div')
    row1_elt1_elt1_1.setAttribute('class','widget')
    row1_elt1_elt1_1.innerHTML = `
        <div id="search2" class="widget-search mb-0">
            <form role="search" method="get" id="searchform" class="searchform">
                <div>
                    <input type="text" class="border rounded" name="s" id="s" placeholder="Search Keywords...">
                    <input type="submit" id="searchsubmit" value="Search">
                </div>
            </form>
        </div>
    `
    row1_elt1_elt1.appendChild(row1_elt1_elt1_1)

    let row1_elt1_elt1_2 = document.createElement('div')
    row1_elt1_elt1_2.setAttribute('class','widget mt-4 pt-2')   
    
    let row1_elt1_elt1_2_1 = document.createElement('h5')
    row1_elt1_elt1_2_1.setAttribute('class','widget-title')
    row1_elt1_elt1_2_1.innerText = 'Categories'

    let row1_elt1_elt1_2_2 = document.createElement('ul')
    row1_elt1_elt1_2_2.setAttribute('class','list-unstyled mt-4 mb-0 blog-categories')
  
    var categories = ['Men','Women','Electronics','Jewellery','Shoes','Kid\'s wear','Sports','Toys','Gift Corners','Bamba']
    categories.forEach((categorie)=>
	{
        let li = document.createElement('li')
        let a = document.createElement('a')
        a.setAttribute('href','#')
        a.innerText = categorie
        li.appendChild(a)
        row1_elt1_elt1_2_2.appendChild(li)
        
    })

    row1_elt1_elt1_2.appendChild(row1_elt1_elt1_2_1)
    row1_elt1_elt1_2.appendChild(row1_elt1_elt1_2_2)
    row1_elt1_elt1.appendChild(row1_elt1_elt1_2)

    row1_elt1.appendChild(row1_elt1_elt1)
    row1.appendChild(row1_elt1)
    s_elt1.appendChild(row1)

    // 
    let row2 = document.createElement('div')
    row2.setAttribute('class','col-lg-9 col-md-8 col-12 mt-5 pt-2 mt-sm-0 pt-sm-0')

    let row2_elt1 = document.createElement('div')
    row2_elt1.setAttribute('class','row align-items-center')

    let row2_elt1_1 = document.createElement('div')
    row2_elt1_1.setAttribute('class','col-lg-8 col-md-7')
    row2_elt1_1.innerHTML = `
        <div class="section-title">
            <h5 class="mb-0">Showing 1–15 of 47 results</h5>
        </div>
    `
    row2_elt1.appendChild(row2_elt1_1)

    let row2_elt2 = document.createElement('div')
    row2_elt2.setAttribute('class','row')

    products.forEach((product)=>{
        let row2_elt2_1 = document.createElement('div')
        row2_elt2_1.setAttribute('class','col-lg-4 col-md-6 col-12 mt-4 pt-2')
    
        row2_elt2_1.innerHTML = `
        <div class="card shop-list border-0 position-relative">
            <div class="shop-image position-relative overflow-hidden rounded shadow">
                <a href="shop-product-detail.html"><img src="${product[0]}" class="img-fluid" alt=""></a>
                <a href="shop-product-detail.html" class="overlay-work">
                    <img src="${product[1]}" class="img-fluid" alt="">
                </a>
            </div>
            <div class="card-body content pt-4 p-2">
                <a href="shop-product-detail.html" class="text-dark product-name h6">${product[2]}</a>
                <div class="d-flex justify-content-between mt-1">
                    <h6 class="text-muted small font-italic mb-0 mt-1">${product[3]} <del class="text-danger ml-2">${product[4]}</del> </h6>
                    <ul class="list-unstyled text-warning mb-0">
                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                    </ul>
                </div>
            </div>
        </div>
        
        `
        row2_elt2.appendChild(row2_elt2_1)
    })

    row2.appendChild(row2_elt1)
    row2.appendChild(row2_elt2)
    s_elt1.appendChild(row2)

    elt1.appendChild(s_elt1)
    section2.appendChild(elt1)

    // terminer
    container.appendChild(section1)
    container.appendChild(div1)
    container.appendChild(section2)
    return container
}

//document.querySelector('body').appendChild(header()) ;

if(location.hash == '#Home')
{
    document.querySelector('body').appendChild (homePage());
}
else if(location.hash == '#shop-grids')
{
    document.querySelector('body').appendChild (productPage());
}
else
{
    document.querySelector('body').appendChild (buildContenu());
}
document.querySelector('body').innerHTML += footer();

/*
function navigation()
{
    let links = document.querySelectorAll('a');
    links.forEach((link)=>{
        link.addEventListener('click',(e)=>{
            buildBody(e);
        })
    })
}
navigation()
*/
function buildBody(e)
{
    e.preventDefault();
    console.log(e.target.getAttribute('href'))
    console.log(e.target.parentNode.getAttribute('href'))

    if(e.target.getAttribute('href')=='Home.html')
	{
        let currentPage = document.location.href.substr(document.location.href.lastIndexOf('/')+1,)
        // window.history.pushState('', '', '#'+e.target.getAttribute('href'))
        window.history.pushState('', '', '#'+e.target.getAttribute('href').substr(0,e.target.getAttribute('href').lastIndexOf('.')))
        document.querySelector('body').removeChild(document.querySelector('.contenuPrincipal'))
        document.querySelector('body').insertBefore(homePage(),document.querySelector('footer'))
        navigation()
        location.reload()
          
    }
    else if(e.target.getAttribute('href') == 'shop-grids.html')
	{
        // window.history.pushState('', '', '#'+e.target.getAttribute('href'))
        window.history.pushState('', '', '#'+e.target.getAttribute('href').substr(0,e.target.getAttribute('href').lastIndexOf('.')))
        document.querySelector('body').removeChild(document.querySelector('.contenuPrincipal'))
        document.querySelector('body').insertBefore(productPage(),document.querySelector('footer'))
        navigation()
        location.reload()
    }
    else if(e.target.parentNode.getAttribute('href') == 'index-shop.html')
	{
        window.history.pushState('', '', '#')
        document.querySelector('body').removeChild(document.querySelector('.contenuPrincipal'))
        document.querySelector('body').insertBefore(buildContenu(),document.querySelector('script[src="index.js"]'))
        navigation()
        location.reload()
    }  
}
//navigation()
