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
package FoamX.Editors.TypeEditor;

import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import FoamXServer.CaseServer.IApplication;

import FoamX.App;

public class TypeEditorPanel
    extends javax.swing.JPanel
{
    //--------------------------------------------------------------------------

    private TypeEditorModel typeModel_;

    //--------------------------------------------------------------------------
    /** Creates a new TypeEditorPanel object for manipulating the application class dictionaries.
     */
    public TypeEditorPanel(IApplication app)
    {
        try
        {
            // Initialise the user interface.
            initComponents();
            tree_.putClientProperty("JTree.lineStyle", "Angled");

            // Initialise the type model.
            typeModel_ = new TypeEditorModel(app, tree_, table_);

            // Get the mode to initialise the toolbar.
            typeModel_.initialiseToolbar(toolBar_);

            // Make sure the tree is displayed properly.
            tree_.updateUI();
            table_.updateUI();
        }
        catch (Exception ex)
        {
            App.handleAllExceptions(ex);
        }
    }

    //--------------------------------------------------------------------------
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        contextMenu_ = new javax.swing.JPopupMenu();
        splitPane_ = new javax.swing.JSplitPane();
        treePanel_ = new javax.swing.JPanel();
        buttonPanel_ = new javax.swing.JPanel();
        toolBar_ = new javax.swing.JToolBar();
        treeScrollPane_ = new javax.swing.JScrollPane();
        tree_ = new javax.swing.JTree();
        tablePanel_ = new javax.swing.JPanel();
        tableScrollPane_ = new javax.swing.JScrollPane();
        table_ = new javax.swing.JTable();
        
        
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints1;
        
        setFont(new java.awt.Font("Dialog", 0, 10));
        splitPane_.setDividerLocation(200);
        splitPane_.setLastDividerLocation(200);
        treePanel_.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints2;
        
        buttonPanel_.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        buttonPanel_.setBorder(new javax.swing.border.EtchedBorder());
        toolBar_.setFloatable(false);
        toolBar_.setFont(new java.awt.Font("Dialog", 0, 8));
        buttonPanel_.add(toolBar_);
        
        gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints2.weightx = 1.0;
        treePanel_.add(buttonPanel_, gridBagConstraints2);
        
        treeScrollPane_.setAutoscrolls(true);
        tree_.setFont(new java.awt.Font("Dialog", 0, 10));
        tree_.setShowsRootHandles(true);
        tree_.setLargeModel(true);
        tree_.setAutoscrolls(true);
        tree_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnTreeMouseClicked(evt);
            }
        });
        
        treeScrollPane_.setViewportView(tree_);
        
        gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.weighty = 1.0;
        treePanel_.add(treeScrollPane_, gridBagConstraints2);
        
        splitPane_.setLeftComponent(treePanel_);
        
        tablePanel_.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints3;
        
        tableScrollPane_.setAutoscrolls(true);
        table_.setFont(new java.awt.Font("Dialog", 0, 10));
        table_.setPreferredScrollableViewportSize(new java.awt.Dimension(0, 0));
        tableScrollPane_.setViewportView(table_);
        
        gridBagConstraints3 = new java.awt.GridBagConstraints();
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 0;
        gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints3.insets = new java.awt.Insets(5, 5, 5, 5);
        gridBagConstraints3.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.weighty = 1.0;
        tablePanel_.add(tableScrollPane_, gridBagConstraints3);
        
        splitPane_.setRightComponent(tablePanel_);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.insets = new java.awt.Insets(10, 10, 10, 10);
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.weighty = 1.0;
        add(splitPane_, gridBagConstraints1);
        
    }//GEN-END:initComponents

    //--------------------------------------------------------------------------

  private void OnTreeMouseClicked (java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_OnTreeMouseClicked
        try
        {
            // Get the node object for the current selection.
            TreePath tp = tree_.getPathForLocation(evt.getX(), evt.getY());
            if (tp != null)
            {
                // Make sure the node is selected.
                tree_.getSelectionModel().clearSelection();
                tree_.getSelectionModel().setSelectionPath(tp);

                // Check for popup menu trigger.
                //if (evt.isPopupTrigger())       // Why doesn't this fucking work!
                if (evt.getModifiers() == evt.BUTTON3_MASK)   // Check explicitly for right mouse click.
                {
                    // Construct an appropriate context menu,
                    DefaultMutableTreeNode nodeItem = (DefaultMutableTreeNode)tp.getLastPathComponent();
                    typeModel_.initialiseContextMenu(nodeItem, contextMenu_);

                    // Show context menu.
                    contextMenu_.show(tree_, evt.getX(), evt.getY());
                }
            }
        }
        catch (Exception ex)
        {
            App.handleAllExceptions(ex);
        }
  }//GEN-LAST:event_OnTreeMouseClicked

    //--------------------------------------------------------------------------

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPopupMenu contextMenu_;
  private javax.swing.JSplitPane splitPane_;
  private javax.swing.JPanel treePanel_;
  private javax.swing.JPanel buttonPanel_;
  private javax.swing.JToolBar toolBar_;
  private javax.swing.JScrollPane treeScrollPane_;
  private javax.swing.JTree tree_;
  private javax.swing.JPanel tablePanel_;
  private javax.swing.JScrollPane tableScrollPane_;
  private javax.swing.JTable table_;
  // End of variables declaration//GEN-END:variables

    //--------------------------------------------------------------------------

    public void updateModel()
    {
        typeModel_.updateModel();
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
}



