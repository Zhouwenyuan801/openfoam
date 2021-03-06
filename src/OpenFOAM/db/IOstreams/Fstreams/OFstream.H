/*---------------------------------------------------------------------------*\
  =========                 |
  \\      /  F ield         | OpenFOAM: The Open Source CFD Toolbox
   \\    /   O peration     |
    \\  /    A nd           | www.openfoam.com
     \\/     M anipulation  |
-------------------------------------------------------------------------------
    Copyright (C) 2011-2017 OpenFOAM Foundation
    Copyright (C) 2017-2020 OpenCFD Ltd.
-------------------------------------------------------------------------------
License
    This file is part of OpenFOAM.

    OpenFOAM is free software: you can redistribute it and/or modify it
    under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    OpenFOAM is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
    for more details.

    You should have received a copy of the GNU General Public License
    along with OpenFOAM.  If not, see <http://www.gnu.org/licenses/>.

Class
    Foam::OFstream

Description
    Output to file stream, using an OSstream

SourceFiles
    OFstream.C

\*---------------------------------------------------------------------------*/

#ifndef OFstream_H
#define OFstream_H

#include "OSstream.H"
#include "fileName.H"
#include "className.H"
#include <fstream>
#include <memory>

// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * //

namespace Foam
{

namespace Detail
{

/*---------------------------------------------------------------------------*\
                  Class Detail::OFstreamAllocator Declaration
\*---------------------------------------------------------------------------*/

//- A std::ostream with the ability to handle compressed files
class OFstreamAllocator
{
protected:

    // Member Data

        //- The allocated stream pointer (ofstream or ogzstream).
        std::unique_ptr<std::ostream> allocatedPtr_;


    // Constructors

        //- Construct from pathname
        OFstreamAllocator
        (
            const fileName& pathname,
            IOstream::compressionType comp = IOstream::UNCOMPRESSED,
            const bool append = false
        );
};

} // End namespace Detail


/*---------------------------------------------------------------------------*\
                          Class OFstream Declaration
\*---------------------------------------------------------------------------*/

class OFstream
:
    public Detail::OFstreamAllocator,
    public OSstream
{
public:

    //- Declare type-name (with debug switch)
    ClassName("OFstream");


    // Constructors

        //- Construct from pathname
        explicit OFstream
        (
            const fileName& pathname,
            IOstreamOption streamOpt = IOstreamOption(),
            const bool append = false
        );

        //- Construct from pathname, format (version, compression)
        OFstream
        (
            const fileName& pathname,
            streamFormat fmt,
            versionNumber ver = currentVersion,
            compressionType comp = compressionType::UNCOMPRESSED,
            const bool append = false
        )
        :
            OFstream(pathname, IOstreamOption(fmt, comp, ver), append)
        {}


    //- Destructor
    ~OFstream() = default;


    // Member Functions

    // Access

        //- Read/write access to the name of the stream
        using OSstream::name;


    // STL stream

        //- Access to underlying std::ostream
        virtual std::ostream& stdStream();

        //- Const access to underlying std::ostream
        virtual const std::ostream& stdStream() const;


    // Print

        //- Print stream description to Ostream
        void print(Ostream& os) const;
};


// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * //

//- Global predefined null output stream "/dev/null"
extern OFstream Snull;

// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * //

} // End namespace Foam

// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * //

#endif

// ************************************************************************* //
