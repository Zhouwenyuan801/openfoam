/*---------------------------------------------------------------------------*\
  =========                 |
  \\      /  F ield         | OpenFOAM: The Open Source CFD Toolbox
   \\    /   O peration     |
    \\  /    A nd           | Copyright (C) 1991-2007 OpenCFD Ltd.
     \\/     M anipulation  |
-------------------------------------------------------------------------------
License
    This file is part of OpenFOAM.

    OpenFOAM is free software; you can redistribute it and/or modify it
    under the terms of the GNU General Public License as published by the
    Free Software Foundation; either version 2 of the License, or (at your
    option) any later version.

    OpenFOAM is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
    for more details.

    You should have received a copy of the GNU General Public License
    along with OpenFOAM; if not, write to the Free Software Foundation,
    Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA

\*---------------------------------------------------------------------------*/
package FoamX.WindowManagement;

import java.awt.*;
import javax.swing.*;

import FoamX.App;

public class FoamXInternalFrame
    extends javax.swing.JInternalFrame
{
    //--------------------------------------------------------------------------

    protected int windowID_;       // The ID of the window hosted by this frame.

    //--------------------------------------------------------------------------

    /** Creates new form FoamXInternalFrame */
    public FoamXInternalFrame(int windowID, JComponent component)
    {
        try
        {
            windowID_ = windowID;

            // Default GUI initialisation.
            initComponents();

            // Set the component for this window.
            getContentPane().add(component, java.awt.BorderLayout.CENTER);
            pack();

            // Set the frame title.
            setTitle(component.toString());
        }
        catch (Exception ex)
        {
            App.handleAllExceptions(ex);
        }
    }

    //--------------------------------------------------------------------------

    public int getWindowID()
    {
        return windowID_;
    }

    //--------------------------------------------------------------------------
    /** This method is called from within the constructor to initialize the form.
     *  WARNING: Do NOT modify this code. The content of this method is always regenerated by the FormEditor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setClosable(true);
    }//GEN-END:initComponents

    //--------------------------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
}



