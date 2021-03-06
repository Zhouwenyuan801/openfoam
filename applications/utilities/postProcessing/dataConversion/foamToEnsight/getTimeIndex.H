// Read time index from */uniform/time, but treat 0 and constant specially
// or simply increment from the '-index' option if it was supplied

label timeIndex = 0;
{
    if (doConsecutive)
    {
        timeIndex = indexingNumber++;
    }
    else if
    (
        runTime.timeName() != runTime.constant()
     && runTime.timeName() != "0"
    )
    {
        IOobject io
        (
            "time",
            runTime.timeName(),
            "uniform",
            runTime,
            IOobject::READ_IF_PRESENT,
            IOobject::NO_WRITE,
            false  // no register
        );

        if (io.typeHeaderOk<IOdictionary>(true, false))
        {
            io.readOpt() = IOobject::MUST_READ_IF_MODIFIED;
            IOdictionary timeObject(io);

            timeObject.readEntry("index", timeIndex);
        }
        else
        {
            Info<< "skip ... missing entry " << io.objectPath() << endl;
            continue;
        }
    }
}
