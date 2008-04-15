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

package FoamX.Modules.CaseEditor;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import org.omg.CORBA.StringHolder;

import FoamX.App;
import FoamX.Editors.DictionaryEntryEditor.CompoundEntryEvent;
import FoamX.Editors.DictionaryEntryEditor.CompoundEntryListener;
import FoamX.Editors.DictionaryEntryEditor.DictionaryEntry;
import FoamX.Editors.DictionaryEntryEditor.EntryCache.DictionaryEntryCache;
import FoamX.Editors.DictionaryEntryEditor.DictionaryEntryCellEditor;
import FoamX.Editors.DictionaryEntryEditor.DictionaryEntryCellRenderer;
import FoamXServer.CaseServer.ICaseServer;
import FoamXServer.CaseServer.IGeometricField;
import FoamXServer.CaseServer.IGeometricFieldHolder;
import FoamXServer.IDictionaryEntryHolder;

public class FieldPropertiesWindow
    extends javax.swing.JPanel
{
    //--------------------------------------------------------------------------

    private static final int DEFAULT_WIDTH = 400;

    private FieldPropertiesTableModel tableModel_;
    private String fieldName_;

    //--------------------------------------------------------------------------
    /** FieldPropertiesWindow constructor. */
    public FieldPropertiesWindow(ICaseServer caseServer, String fieldName)
    {
        // Initialise the table model.
        tableModel_ = new FieldPropertiesTableModel(caseServer, fieldName);
        fieldName_  = fieldName;

        // Initialise the table.
        initComponents();


        // Set cell renderer and editor for value column.
        table_.getColumn
        (
            tableModel_.getValueColumnTitle()
        ).setCellRenderer(new DictionaryEntryCellRenderer());
        table_.getColumn
        (
            tableModel_.getValueColumnTitle()
        ).setCellEditor(new DictionaryEntryCellEditor());

        // Resize to show the defined rows only.
        // Calculate size: table + panel + some extra (= 1 row height)
        int height =
            table_.getRowHeight() * (tableModel_.getRowCount() + 2)
            + (int)getMinimumSize().getHeight();    // panel size

        setPreferredSize(new java.awt.Dimension(DEFAULT_WIDTH, height));

    }

    //--------------------------------------------------------------------------

    public String toString()
    {
        // Used to set the title of the host internal frame window.
        //return "Field : " + fieldName_;
        return fieldName_;
    }

    //--------------------------------------------------------------------------

    public void refresh()
    {
        // The boundary type may have changed for this field.
        // Update the table model.
        tableModel_.refresh();
        setSize(new java.awt.Dimension(DEFAULT_WIDTH, 200));
        table_.updateUI();
    }

    //--------------------------------------------------------------------------
    /** Provide access to the table model object. */
    public FieldPropertiesTableModel getTableModel()
    {
        return tableModel_;
    }

    //--------------------------------------------------------------------------
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        tableScrollPane_ = new javax.swing.JScrollPane();
        table_ = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        setFont(new java.awt.Font("Dialog", 0, 10));
        table_.setFont(new java.awt.Font("Dialog", 0, 10));
        table_.setModel(tableModel_);
        tableScrollPane_.setViewportView(table_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(tableScrollPane_, gridBagConstraints);

    }//GEN-END:initComponents

    //--------------------------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane tableScrollPane_;
    private javax.swing.JTable table_;
    // End of variables declaration//GEN-END:variables

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    static class FieldPropertiesTableModel
    extends FoamX.Editors.DictionaryEntryEditor.DictionaryEntryTableModel
    {
        //----------------------------------------------------------------------

        protected ICaseServer caseServer_;
        protected String fieldName_;

        //----------------------------------------------------------------------
        /**
         * FieldPropertiesTableModel constructor. Construct the table model from
         * the specified field values object in the current case server.
         */
        public FieldPropertiesTableModel
        (
            ICaseServer caseServer,
            String fieldName
        )
        {
            try
            {
                caseServer_ = caseServer;
                fieldName_  = fieldName;

                // Get field values object for the specified field.
                IGeometricFieldHolder holder = new IGeometricFieldHolder();
                caseServer.getFieldValues(fieldName_, holder);
                IGeometricField fieldValObject = holder.value;

                IDictionaryEntryHolder dictEntryHolder =
                    new IDictionaryEntryHolder();

                //--------------------------------------------------------------
                // Get internal field value dictionary entry object.
                fieldValObject.getInternalFieldValue(dictEntryHolder);
                DictionaryEntry dictEntry1 =
                    DictionaryEntryCache.New
                    (
                        dictEntryHolder.value,
                        "Internal Field Value"
                    );
                dictEntryList_.add(0, dictEntry1);
                dictEntryMap_.put("Internal Field Value", dictEntry1);

//                //--------------------------------------------------------------
//               // Get reference level dictionary entry object.
//                fieldValObject.getReferenceLevelValue(dictEntryHolder);
//                DictionaryEntry dictEntry2 =
//                    DictionaryEntryCache.New
//                    (
//                        dictEntryHolder.value,
//                        "Reference Level"
//                    );
//                dictEntryList_.add(1, dictEntry2);
//                dictEntryMap_.put("Reference Level", dictEntry2);

                //--------------------------------------------------------------
                // Add entries for each patch that requires a value for this
                // field.
                String[] patchNames = caseServer.patchNames();
                for (int nPatch = 0; nPatch <patchNames.length; nPatch++)
                {
                    String patchName = patchNames[nPatch];
/*
                    // Get current boundary type for this patch.
                    StringHolder bndTypeHolder = new StringHolder();
                    caseServer.getPatchPhysicalType(patchName, bndTypeHolder);
                    String patchPhysicalType = bndTypeHolder.value;

                    // Get Boundary Type Descriptor object.
                    IPatchPhysicalTypeDescriptorHolder bndTypeDescHolder = new IPatchPhysicalTypeDescriptorHolder();
                    caseServer.application().getPatchPhysicalType(patchPhysicalType, bndTypeDescHolder);
                    BoundaryDefinitionModelItem bndInfo = new BoundaryDefinitionModelItem(bndTypeDescHolder.value);

                    // Get patch field type descriptor for this field.
                    String patchFieldType = bndInfo.getPatchFieldType(fieldName_);
                    IPatchFieldDescriptorHolder patchFieldDescHolder = new IPatchFieldDescriptorHolder();
                    caseServer.foamProperties().getPatchFieldType(patchFieldType, patchFieldDescHolder);
                    IPatchFieldDescriptor patchFieldDesc = patchFieldDescHolder.value;
*/
                    // Get dictionary entry object for the extra parameters if
                    // required.
                    fieldValObject.getPatchFieldParameters
                    (
                        patchName,
                        dictEntryHolder
                    );
                    if (dictEntryHolder.value != null)
                    {
                        DictionaryEntry patchEntry =
                            new PatchEntry(patchName, dictEntryHolder.value);
                        dictEntryList_.add(dictEntryList_.size(), patchEntry);
                        dictEntryMap_.put(patchName, patchEntry);

                        // Subscribe to the openSubDictionary event so that we
                        // can forward
                        // the edit event to the listeners of this object.
                        patchEntry.addCompoundEntryListener(this);
                    }
                }
            }
            catch (Exception ex)
            {
                App.handleAllExceptions(ex);
            }
        }

        //----------------------------------------------------------------------

        public void refresh()
        {
            // The boundary type may have changed for this field. Rebuild
            // the table.
            try
            {
                dictEntryList_.clear();
                dictEntryMap_.clear();

                // Get field values object for the specified field.
                IGeometricFieldHolder holder = new IGeometricFieldHolder();
                caseServer_.getFieldValues(fieldName_, holder);
                IGeometricField fieldValObject = holder.value;

                IDictionaryEntryHolder dictEntryHolder =
                    new IDictionaryEntryHolder();

                //--------------------------------------------------------------
                // Get internal field value dictionary entry object.
                fieldValObject.getInternalFieldValue(dictEntryHolder);
                DictionaryEntry dictEntry1 =
                    DictionaryEntryCache.New
                    (
                        dictEntryHolder.value,
                        "Internal Field Value"
                    );
                dictEntryList_.add(0, dictEntry1);
                dictEntryMap_.put("Internal Field Value", dictEntry1);

//                //--------------------------------------------------------------
//                // Get reference level dictionary entry object.
//                fieldValObject.getReferenceLevelValue(dictEntryHolder);
//                DictionaryEntry dictEntry2 =
//                    DictionaryEntryCache.New
//                    (
//                        dictEntryHolder.value,
//                        "Reference Level"
//                    );
//                dictEntryList_.add(1, dictEntry2);
//                dictEntryMap_.put("Reference Level", dictEntry2);

                //--------------------------------------------------------------
                // Add entries for each patch that requires a value for this
                // field.
                String[] patchNames = caseServer_.patchNames();
                for (int nPatch = 0; nPatch <patchNames.length; nPatch++)
                {
                    String patchName = patchNames[nPatch];
/*
                    // Get current boundary type for this patch.
                    StringHolder bndTypeHolder = new StringHolder();
                    caseServer.getPatchPhysicalType(patchName, bndTypeHolder);
                    String patchPhysicalType = bndTypeHolder.value;

                    // Get Boundary Type Descriptor object.
                    IPatchPhysicalTypeDescriptorHolder bndTypeDescHolder = new IPatchPhysicalTypeDescriptorHolder();
                    caseServer.application().getPatchPhysicalType(patchPhysicalType, bndTypeDescHolder);
                    BoundaryDefinitionModelItem bndInfo = new BoundaryDefinitionModelItem(bndTypeDescHolder.value);

                    // Get patch field type descriptor for this field.
                    String patchFieldType = bndInfo.getPatchFieldType(fieldName_);
                    IPatchFieldDescriptorHolder patchFieldDescHolder = new IPatchFieldDescriptorHolder();
                    caseServer.foamProperties().getPatchFieldType(patchFieldType, patchFieldDescHolder);
                    IPatchFieldDescriptor patchFieldDesc = patchFieldDescHolder.value;
*/
                    // Get dictionary entry object for the extra parameters if required.
                    fieldValObject.getPatchFieldParameters
                    (
                        patchName,
                        dictEntryHolder
                    );
                    if (dictEntryHolder.value != null)
                    {
                        DictionaryEntry patchEntry =
                            new PatchEntry
                            (
                                patchName,
                                dictEntryHolder.value
                            );
                        dictEntryList_.add(dictEntryList_.size(), patchEntry);
                        dictEntryMap_.put(patchName, patchEntry);

                        // Subscribe to the openSubDictionary event so that we
                        // can forward
                        // the edit event to the listeners of this object.
                        patchEntry.addCompoundEntryListener(this);
                    }
                }

                // Fire event to let everyone know.
                fireTableDataChanged();
            }
            catch (Exception ex)
            {
                App.handleAllExceptions(ex);
            }
        }

        //----------------------------------------------------------------------
        //--- CompoundEntryListener Interface Methods
        //----------------------------------------------------------------------

        public boolean openSubDictionary(CompoundEntryEvent evt)
        {
            // Bounce the openSubDictionary event to any listeneres.
            return fireOpenSubDictionaryEvent(evt);
        }

        //----------------------------------------------------------------------

        protected boolean fireOpenSubDictionaryEvent(CompoundEntryEvent evt)
        {
            try
            {
                // Send the patch name to the module.

                // Process the listeners last to first, notifying those that
                // are interested in this event.
                Object[] listeners = listenerList_.getListenerList();

                // Prepend the field name and send to the module.
                String patchFieldName = fieldName_ + "/" + evt.getName();

                // Create the event object.
                CompoundEntryEvent event =
                    new CompoundEntryEvent
                    (
                        this,
                        CompoundEntryEvent.TYPE_PATCH,
                        patchFieldName
                    );

                // Fire the event.
                for (int i = listeners.length - 2; i>= 0; i -= 2)
                {
                    if (listeners[i] == CompoundEntryListener.class)
                    {
                        return
                        (
                            (CompoundEntryListener)listeners[i+1]
                        ).openSubDictionary(event);
                    }
                }
            }
            catch (Exception ex)
            {
                App.handleAllExceptions(ex);
            }

            return false;
        }

        //----------------------------------------------------------------------
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
}


