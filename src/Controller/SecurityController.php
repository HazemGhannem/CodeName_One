<?php

namespace App\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;

class SecurityController extends AbstractController
{  
   
    
    /**
     * @Route("/login", name="app_login",methods={"POST"})
     */
    public function login()
    {
        


        return $this->json([
            'email' => $this->getUser() ? $this->getUser()->getEmail() : null,
            
        ]);
        // return $this->render('security/login.html.twig', 
        // ['last_username' => $lastUsername,
        //  'error' => $error]);
    }
 
    

    /**
     * @Route("/logout", name="app_logout")
     */
    public function logout(): void
    {
        throw new \LogicException('This method can be blank - it will be intercepted by the logout key on your firewall.');
    }
    
    
}
